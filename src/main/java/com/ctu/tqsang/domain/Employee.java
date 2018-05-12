package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeid;

	private String type;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="personid")
	private Person person;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

	//bi-directional many-to-one association to House
	@OneToMany(mappedBy="employee")
	private List<House> houses;

	//bi-directional many-to-one association to News
	@OneToMany(mappedBy="employee")
	private List<News> news;

	public Employee() {
	}

	public int getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<House> getHouses() {
		return this.houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

	public House addHous(House hous) {
		getHouses().add(hous);
		hous.setEmployee(this);

		return hous;
	}

	public House removeHous(House hous) {
		getHouses().remove(hous);
		hous.setEmployee(null);

		return hous;
	}

	public List<News> getNews() {
		return this.news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public News addNew(News new) {
		getNews().add(new);
		new.setEmployee(this);

		return new;
	}

	public News removeNew(News new) {
		getNews().remove(new);
		new.setEmployee(null);

		return new;
	}

}