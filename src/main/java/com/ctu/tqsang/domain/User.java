package com.ctu.tqsang.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.ctu.tqsang.util.Const;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
    private int id;

//    @NotEmpty
//    @Column(name = "name")
//    private String name;

    @NotEmpty
    @Email
    @Column(name = "username")
    private String email;

    @NotEmpty
    @Length(min = 6)
    @Column(name = "password")
    private String password;
    
    @Transient
    @NotEmpty
    private String confirmPassword;

    @Column(name = "image", nullable = true)
    private String avatar = Const.DEFAULT_AVATAR;

    @Column(name = "point", nullable = true)
    private int point = Const.INIT_POINT;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "userrole", 
	    joinColumns = { @JoinColumn(name = "userid") }, 
	    inverseJoinColumns = { @JoinColumn(name = "roleid") }
    )
    private Set<Role> roles = new HashSet<>();
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("id DESC")
    private Set<Question> questions = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Answer> answers = new HashSet<>();
    
    //Custom Edit
  //bi-directional many-to-one association to Customer
  	@OneToOne(mappedBy="user")
  	Customer customers;

  	//bi-directional many-to-one association to Employee
  	@OneToOne(mappedBy="user")
  	Employee employees;
    
    public User() {
    	roles.add(new Role("ROLE_MEMBER"));
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
    public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public boolean isAdmin() {
		for (Role role : roles) {
			if (role.getName().equals("ROLE_ADMIN")) {
				return true;
			}
		}
		return false;
	}

	public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	

}
