package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the propertydetail database table.
 * 
 */
@Entity
@Table(name="propertydetail")
@NamedQuery(name="Propertydetail.findAll", query="SELECT p FROM Propertydetail p")
public class Propertydetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PropertydetailPK id;

	private int amount;

	//bi-directional many-to-one association to Property
	@ManyToOne
	@JoinColumn(name="propertyid")
	private Property property;

	//bi-directional many-to-one association to House
	@ManyToOne
	@JoinColumn(name="houseid")
	private House house;

	public Propertydetail() {
	}

	public PropertydetailPK getId() {
		return this.id;
	}

	public void setId(PropertydetailPK id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

}