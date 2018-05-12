package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the propertycategory database table.
 * 
 */
@Entity
@Table(name="propertycategory")
@NamedQuery(name="Propertycategory.findAll", query="SELECT p FROM Propertycategory p")
public class Propertycategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int propertycategoryid;

	//bi-directional many-to-one association to Property
	@OneToMany(mappedBy="propertycategory")
	private List<Property> properties;

	public Propertycategory() {
	}

	public int getPropertycategoryid() {
		return this.propertycategoryid;
	}

	public void setPropertycategoryid(int propertycategoryid) {
		this.propertycategoryid = propertycategoryid;
	}

	public List<Property> getProperties() {
		return this.properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public Property addProperty(Property property) {
		getProperties().add(property);
		property.setPropertycategory(this);

		return property;
	}

	public Property removeProperty(Property property) {
		getProperties().remove(property);
		property.setPropertycategory(null);

		return property;
	}

}