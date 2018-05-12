package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the promotiondetail database table.
 * 
 */
@Embeddable
public class PromotiondetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int promotionid;

	@Column(insertable=false, updatable=false)
	private int houseid;

	public PromotiondetailPK() {
	}
	public int getPromotionid() {
		return this.promotionid;
	}
	public void setPromotionid(int promotionid) {
		this.promotionid = promotionid;
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
		if (!(other instanceof PromotiondetailPK)) {
			return false;
		}
		PromotiondetailPK castOther = (PromotiondetailPK)other;
		return 
			(this.promotionid == castOther.promotionid)
			&& (this.houseid == castOther.houseid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.promotionid;
		hash = hash * prime + this.houseid;
		
		return hash;
	}
}