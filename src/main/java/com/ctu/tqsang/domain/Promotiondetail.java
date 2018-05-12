package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the promotiondetail database table.
 * 
 */
@Entity
@Table(name="promotiondetail")
@NamedQuery(name="Promotiondetail.findAll", query="SELECT p FROM Promotiondetail p")
public class Promotiondetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PromotiondetailPK id;

	private int reducedprice;

	//bi-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumn(name="promotionid")
	private Promotion promotion;

	//bi-directional many-to-one association to House
	@ManyToOne
	@JoinColumn(name="houseid")
	private House house;

	public Promotiondetail() {
	}

	public PromotiondetailPK getId() {
		return this.id;
	}

	public void setId(PromotiondetailPK id) {
		this.id = id;
	}

	public int getReducedprice() {
		return this.reducedprice;
	}

	public void setReducedprice(int reducedprice) {
		this.reducedprice = reducedprice;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

}