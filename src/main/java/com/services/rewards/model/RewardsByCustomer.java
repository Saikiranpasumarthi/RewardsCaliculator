package com.services.rewards.model;

import java.util.List;

public class RewardsByCustomer {
	private Integer Customer_Id;
	private String Customer_Name;
	private Double Total_Purchase;
	private Integer Total_Rewards;
	private List<Reward_Breakdown_Monthly> rewardsMonthly;
	
	public RewardsByCustomer(Integer customer_Id, String customer_Name, Double total_Purchase, Integer total_Rewards,
			List<Reward_Breakdown_Monthly> rewardsMonthly) {
		super();
		Customer_Id = customer_Id;
		Customer_Name = customer_Name;
		Total_Purchase = total_Purchase;
		Total_Rewards = total_Rewards;
		this.rewardsMonthly = rewardsMonthly;
	}

	public RewardsByCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(Integer customer_Id) {
		Customer_Id = customer_Id;
	}

	public String getCustomer_Name() {
		return Customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}

	public Double getTotal_Purchase() {
		return Total_Purchase;
	}

	public void setTotal_Purchase(Double total_Purchase) {
		Total_Purchase = total_Purchase;
	}

	public Integer getTotal_Rewards() {
		return Total_Rewards;
	}

	public void setTotal_Rewards(Integer total_Rewards) {
		Total_Rewards = total_Rewards;
	}

	public List<Reward_Breakdown_Monthly> getRewardsMonthly() {
		return rewardsMonthly;
	}

	public void setRewardsMonthly(List<Reward_Breakdown_Monthly> rewardsMonthly) {
		this.rewardsMonthly = rewardsMonthly;
	}

	@Override
	public String toString() {
		return "RewardsByCustomer [Customer_Id=" + Customer_Id + ", Customer_Name=" + Customer_Name
				+ ", Total_Purchase=" + Total_Purchase + ", Total_Rewards=" + Total_Rewards + ", rewardsMonthly="
				+ rewardsMonthly + "]";
	}
	
	
}
