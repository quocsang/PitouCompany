package com.ctu.tqsang.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vote")
public class Vote implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="voteid")
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answerid")
    private Answer answer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private User user;

    public Vote() {
    }
    
    public Vote(Answer answer, User user) {
		super();
		this.answer = answer;
		this.user = user;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }
    
}
