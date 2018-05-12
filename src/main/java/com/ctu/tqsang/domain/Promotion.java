package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the promotion database table.
 * 
 */
@Entity
@Table(name="promotion")
@NamedQuery(name="Promotion.findAll", query="SELECT p FROM Promotion p")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int promotionid;

	@Lob
	private String content;

	private String dateend;

	private String datestart;

	//bi-directional many-to-one association to Promotiondetail
	@OneToMany(mappedBy="promotion")
	private List<Promotiondetail> promotiondetails;

	public Promotion() {
	}

	public int getPromotionid() {
		return this.promotionid;
	}

	public void setPromotionid(int promotionid) {
		this.promotionid = promotionid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDateend() {
		return this.dateend;
	}

	public void setDateend(String dateend) {
		this.dateend = dateend;
	}

	public String getDatestart() {
		return this.datestart;
	}

	public void setDatestart(String datestart) {
		this.datestart = datestart;
	}

	public List<Promotiondetail> getPromotiondetails() {
		return this.promotiondetails;
	}

	public void setPromotiondetails(List<Promotiondetail> promotiondetails) {
		this.promotiondetails = promotiondetails;
	}

	public Promotiondetail addPromotiondetail(Promotiondetail promotiondetail) {
		getPromotiondetails().add(promotiondetail);
		promotiondetail.setPromotion(this);

		return promotiondetail;
	}

	public Promotiondetail removePromotiondetail(Promotiondetail promotiondetail) {
		getPromotiondetails().remove(promotiondetail);
		promotiondetail.setPromotion(null);

		return promotiondetail;
	}

}