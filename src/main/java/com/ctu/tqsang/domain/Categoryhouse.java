package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="categoryhouse")
@NamedQuery(name="Categoryhouse.findAll", query="SELECT c FROM Categoryhouse c")
public class Categoryhouse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int chid;

	//bi-directional many-to-one association to House
	@OneToMany(mappedBy="categoryhouse")
	private List<House> houses;

	public Categoryhouse() {
	}

	public int getCategoryid() {
		return this.chid;
	}

	public void setCategoryid(int categoryid) {
		this.chid = categoryid;
	}

	public List<House> getHouses() {
		return this.houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

	public House addHous(House hous) {
		getHouses().add(hous);
		hous.setCategory(this);

		return hous;
	}

	public House removeHous(House hous) {
		getHouses().remove(hous);
		hous.setCategory(null);

		return hous;
	}

}