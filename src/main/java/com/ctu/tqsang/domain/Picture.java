package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the picture database table.
 * 
 */
@Entity
@Table(name="picture")
@NamedQuery(name="Picture.findAll", query="SELECT p FROM Picture p")
public class Picture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pictureid;

	private String datecreate;

	@Lob
	private String src;

	//bi-directional many-to-many association to House
	@ManyToMany
	@JoinTable(
		name="housepicture"
		, joinColumns={
			@JoinColumn(name="pictureid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="houseid")
			}
		)
	private List<House> houses;

	public Picture() {
	}

	public int getPictureid() {
		return this.pictureid;
	}

	public void setPictureid(int pictureid) {
		this.pictureid = pictureid;
	}

	public String getDatecreate() {
		return this.datecreate;
	}

	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}

	public String getSrc() {
		return this.src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public List<House> getHouses() {
		return this.houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

}