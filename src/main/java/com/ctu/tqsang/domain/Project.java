package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@Table(name="project")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int projectid;

	@Lob
	private String content;

	private String datefinish;

	private String datestart;

	//bi-directional many-to-one association to House
	@OneToMany(mappedBy="project")
	private List<House> houses;

	public Project() {
	}

	public int getProjectid() {
		return this.projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDatefinish() {
		return this.datefinish;
	}

	public void setDatefinish(String datefinish) {
		this.datefinish = datefinish;
	}

	public String getDatestart() {
		return this.datestart;
	}

	public void setDatestart(String datestart) {
		this.datestart = datestart;
	}

	public List<House> getHouses() {
		return this.houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

	public House addHous(House hous) {
		getHouses().add(hous);
		hous.setProject(this);

		return hous;
	}

	public House removeHous(House hous) {
		getHouses().remove(hous);
		hous.setProject(null);

		return hous;
	}

}