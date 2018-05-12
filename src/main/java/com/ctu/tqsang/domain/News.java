package com.ctu.tqsang.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the news database table.
 * 
 */
@Entity
@Table(name="news")
@NamedQuery(name="News.findAll", query="SELECT n FROM News n")
public class News implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int newsid;

	@Lob
	private String content;

	@Lob
	private String slug;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Employee employee;

	public News() {
	}

	public int getNewsid() {
		return this.newsid;
	}

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}