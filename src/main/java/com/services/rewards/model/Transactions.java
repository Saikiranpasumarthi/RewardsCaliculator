package com.services.rewards.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "transactions")
public class Transactions {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer.id")
	private Customer customer;
	@NotNull(message="{purchaseTotal.required}")
	@Column(name ="purchaseTotal")
	private Double purchaseTotal;
	@Column(name ="rewardsPoints")
	private Integer rewardsPoints;
	private Date date;
	
	
	public Transactions(Integer id, Customer customer,Double purchaseTotal, Date date,Integer rewardsPoints) {
		super();
		this.id = id;
		this.customer = customer;
		this.purchaseTotal = purchaseTotal;
		this.date = date;
		this.rewardsPoints=rewardsPoints;
	}


	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	

	public Integer getRewardsPoints() {
		return rewardsPoints;
	}


	public void setRewardsPoints(Integer rewardsPoints) {
		this.rewardsPoints = rewardsPoints;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Double getPurchaseTotal() {
		return purchaseTotal;
	}


	public void setPurchaseTotal(Double purchaseTotal) {
		this.purchaseTotal = purchaseTotal;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Transactions [id=" + id + ", customer=" + customer + ", purchaseTotal=" + purchaseTotal + ", date="
				+ date + "]";
	}
	
	
	
	
	
	
}
