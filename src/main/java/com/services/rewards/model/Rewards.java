package com.services.rewards.model;

import java.util.List;

public class Rewards {
	private List<RewardsByCustomer> Customer_Rewards;

	public Rewards(List<RewardsByCustomer> customer_Rewards) {
		super();
		Customer_Rewards = customer_Rewards;
	}

	public Rewards() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<RewardsByCustomer> getCustomer_Rewards() {
		return Customer_Rewards;
	}

	public void setCustomer_Rewards(List<RewardsByCustomer> customer_Rewards) {
		Customer_Rewards = customer_Rewards;
	}
	
	
	
}
