package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressid;

	private String location;

	private String place;

	//bi-directional many-to-one association to Ward
	@ManyToOne
	@JoinColumn(name="wardid")
	private Ward ward;

	//bi-directional many-to-one association to House
	@OneToMany(mappedBy="address")
	private List<House> houses;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="address")
	private List<Person> persons;

	public Address() {
	}

	public int getAddressid() {
		return this.addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Ward getWard() {
		return this.ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public List<House> getHouses() {
		return this.houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

	public House addHous(House hous) {
		getHouses().add(hous);
		hous.setAddress(this);

		return hous;
	}

	public House removeHous(House hous) {
		getHouses().remove(hous);
		hous.setAddress(null);

		return hous;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setAddress(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setAddress(null);

		return person;
	}

}