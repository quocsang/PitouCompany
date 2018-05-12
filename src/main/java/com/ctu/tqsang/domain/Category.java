package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryid;

	//bi-directional many-to-one association to House
	@OneToMany(mappedBy="category")
	private List<House> houses;

	public Category() {
	}

	public int getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
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