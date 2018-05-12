package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the property database table.
 * 
 */
@Entity
@Table(name="property")
@NamedQuery(name="Property.findAll", query="SELECT p FROM Property p")
public class Property implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int propertyid;

	//bi-directional many-to-one association to Propertycategory
	@ManyToOne
	@JoinColumn(name="propertycategoryid")
	private Propertycategory propertycategory;

	//bi-directional many-to-one association to Propertydetail
	@OneToMany(mappedBy="property")
	private List<Propertydetail> propertydetails;

	public Property() {
	}

	public int getPropertyid() {
		return this.propertyid;
	}

	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}

	public Propertycategory getPropertycategory() {
		return this.propertycategory;
	}

	public void setPropertycategory(Propertycategory propertycategory) {
		this.propertycategory = propertycategory;
	}

	public List<Propertydetail> getPropertydetails() {
		return this.propertydetails;
	}

	public void setPropertydetails(List<Propertydetail> propertydetails) {
		this.propertydetails = propertydetails;
	}

	public Propertydetail addPropertydetail(Propertydetail propertydetail) {
		getPropertydetails().add(propertydetail);
		propertydetail.setProperty(this);

		return propertydetail;
	}

	public Propertydetail removePropertydetail(Propertydetail propertydetail) {
		getPropertydetails().remove(propertydetail);
		propertydetail.setProperty(null);

		return propertydetail;
	}

}