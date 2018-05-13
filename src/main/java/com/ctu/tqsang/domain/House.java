package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the house database table.
 * 
 */
@Entity
@Table(name="house")
@NamedQuery(name="House.findAll", query="SELECT h FROM House h")
public class House implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int houseid;

	private String datecreate;

	private String description;

	private String price;

	private int status;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Employee employee;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="addressid")
	private Address address;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectid")
	private Project project;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Categoryhouse categoryhouse;

	//bi-directional many-to-many association to Picture
	@ManyToMany(mappedBy="houses")
	private List<Picture> pictures;

	//bi-directional many-to-one association to Promotiondetail
	@OneToMany(mappedBy="house")
	private List<Promotiondetail> promotiondetails;

	//bi-directional many-to-one association to Propertydetail
	@OneToMany(mappedBy="house")
	private List<Propertydetail> propertydetails;

	public House() {
	}

	public int getHouseid() {
		return this.houseid;
	}

	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}

	public String getDatecreate() {
		return this.datecreate;
	}

	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Categoryhouse getCategory() {
		return this.categoryhouse;
	}

	public void setCategory(Categoryhouse category) {
		this.categoryhouse = category;
	}

	public List<Picture> getPictures() {
		return this.pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public List<Promotiondetail> getPromotiondetails() {
		return this.promotiondetails;
	}

	public void setPromotiondetails(List<Promotiondetail> promotiondetails) {
		this.promotiondetails = promotiondetails;
	}

	public Promotiondetail addPromotiondetail(Promotiondetail promotiondetail) {
		getPromotiondetails().add(promotiondetail);
		promotiondetail.setHouse(this);

		return promotiondetail;
	}

	public Promotiondetail removePromotiondetail(Promotiondetail promotiondetail) {
		getPromotiondetails().remove(promotiondetail);
		promotiondetail.setHouse(null);

		return promotiondetail;
	}

	public List<Propertydetail> getPropertydetails() {
		return this.propertydetails;
	}

	public void setPropertydetails(List<Propertydetail> propertydetails) {
		this.propertydetails = propertydetails;
	}

	public Propertydetail addPropertydetail(Propertydetail propertydetail) {
		getPropertydetails().add(propertydetail);
		propertydetail.setHouse(this);

		return propertydetail;
	}

	public Propertydetail removePropertydetail(Propertydetail propertydetail) {
		getPropertydetails().remove(propertydetail);
		propertydetail.setHouse(null);

		return propertydetail;
	}

}