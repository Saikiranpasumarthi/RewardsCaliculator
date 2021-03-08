package com.services.rewards.model;

public class Reward_Breakdown_Monthly {
	private String Month;
	private Double Purchase_Total;
	private Integer Rewards_Total;
	public Reward_Breakdown_Monthly(String month, Double purchase_Total, Integer rewards_Total) {
		super();
		Month = month;
		Purchase_Total = purchase_Total;
		Rewards_Total = rewards_Total;
	}
	public Reward_Breakdown_Monthly() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMonth() {
		return Month;
	}
	public void setMonth(String month) {
		Month = month;
	}
	public Double getPurchase_Total() {
		return Purchase_Total;
	}
	public void setPurchase_Total(Double purchase_Total) {
		Purchase_Total = purchase_Total;
	}
	public Integer getRewards_Total() {
		return Rewards_Total;
	}
	public void setRewards_Total(Integer rewards_Total) {
		Rewards_Total = rewards_Total;
	}
	
	
	
}
