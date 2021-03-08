package com.services.rewards.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull(message="{name.required}")
	private String name;
	@NotNull(message="{email.required}")
	@Pattern(regexp = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
	        + "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	        + "(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9]"
	        + "(?:[A-Za-z0-9-]*[A-Za-z0-9])?",
	        message = "{invalid.email}")
	private String email;
	
	
	
	public Customer(Integer id, String name,String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
	
}
