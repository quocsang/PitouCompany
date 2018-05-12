package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the propertydetail database table.
 * 
 */
@Embeddable
public class PropertydetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int propertyid;

	@Column(insertable=false, updatable=false)
	private int houseid;

	public PropertydetailPK() {
	}
	public int getPropertyid() {
		return this.propertyid;
	}
	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}
	public int getHouseid() {
		return this.houseid;
	}
	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PropertydetailPK)) {
			return false;
		}
		PropertydetailPK castOther = (PropertydetailPK)other;
		return 
			(this.propertyid == castOther.propertyid)
			&& (this.houseid == castOther.houseid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.propertyid;
		hash = hash * prime + this.houseid;
		
		return hash;
	}
}