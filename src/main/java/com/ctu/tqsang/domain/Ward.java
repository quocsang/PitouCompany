package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ward database table.
 * 
 */
@Entity
@Table(name="ward")
@NamedQuery(name="Ward.findAll", query="SELECT w FROM Ward w")
public class Ward implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wardid;

	private String location;

	private String name;

	private String type;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="ward")
	private List<Address> addresses;

	//bi-directional many-to-one association to District
	@ManyToOne
	@JoinColumn(name="districtid")
	private District district;

	public Ward() {
	}

	public int getWardid() {
		return this.wardid;
	}

	public void setWardid(int wardid) {
		this.wardid = wardid;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setWard(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setWard(null);

		return address;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

}