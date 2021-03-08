package com.services.rewards.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.rewards.model.Customer;
import com.services.rewards.model.Reward_Breakdown_Monthly;
import com.services.rewards.model.Rewards;
import com.services.rewards.model.RewardsByCustomer;
import com.services.rewards.model.Transactions;

@Service
public class RewardsService {

	@Autowired
	CustomerService customerService;
	@Autowired
	TransactionService transactionService;
	
	public Integer getPoints(Double transactionTotal) {
		Integer points = 0;
		
		if (transactionTotal > 50 && transactionTotal <= 100) {
			points += (transactionTotal.intValue() - 50) * 1;
			
		} 
		
		if (transactionTotal > 100) {
			points += (((transactionTotal.intValue() - 100) * 2)+50);  //2 points for every dollar spent over $100
		}
		
		return points;
	}
	
	public Rewards getAllRewardPointsperCustomer() {
		List<Transactions> transactions=transactionService.transactions();
		transactions.stream().forEach(a->a.setRewardsPoints(getPoints(a.getPurchaseTotal())));
		Rewards rewardsDetail=new Rewards();
		List<RewardsByCustomer>  rewards=new ArrayList<RewardsByCustomer>();
		List<Customer> customers=customerService.customers();
		for(Customer customer:customers) {
			RewardsByCustomer customerRewards=new RewardsByCustomer();
			List<Transactions> transactionsByCustomer=transactions.stream().filter(p->p.getCustomer().getId()==customer.getId()).collect(Collectors.toList());
			customerRewards.setCustomer_Id(customer.getId());
			customerRewards.setCustomer_Name(customer.getName());
			customerRewards.setTotal_Purchase(transactionsByCustomer.stream().mapToDouble(a->a.getPurchaseTotal()).sum());
			customerRewards.setTotal_Rewards(transactionsByCustomer.stream().mapToInt(a->a.getRewardsPoints()).sum());
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat simpleMonth=new SimpleDateFormat("MMMM YYYY");
			List<Transactions> trancurrentMonth=transactionsByCustomer.stream().filter(a->((simpleMonth.format(a.getDate())).equals(simpleMonth.format(cal.getTime())))).collect(Collectors.toList());
			cal.add(Calendar.MONTH, -1);
			List<Transactions> tranPreviousMonth1=transactionsByCustomer.stream().filter(a->((simpleMonth.format(a.getDate())).equals(simpleMonth.format(cal.getTime())))).collect(Collectors.toList());
			cal.add(Calendar.MONTH, -1);
			List<Transactions> tranPreviousMonth2=transactionsByCustomer.stream().filter(a->((simpleMonth.format(a.getDate())).equals(simpleMonth.format(cal.getTime())))).collect(Collectors.toList());
			cal.add(Calendar.MONTH, -1);
			List<Transactions> tranPreviousMonth3=transactionsByCustomer.stream().filter(a->((simpleMonth.format(a.getDate())).equals(simpleMonth.format(cal.getTime())))).collect(Collectors.toList());
			
			
			List<Reward_Breakdown_Monthly> rewardsMonthly=new ArrayList<Reward_Breakdown_Monthly>();
			
			
			if(trancurrentMonth.size()>0) {
			    
			    Reward_Breakdown_Monthly currentMonth=new Reward_Breakdown_Monthly();
				currentMonth.setMonth((simpleMonth.format(trancurrentMonth.get(0).getDate())));
				currentMonth.setPurchase_Total(trancurrentMonth.stream().mapToDouble(a->a.getPurchaseTotal()).sum());
				currentMonth.setRewards_Total(trancurrentMonth.stream().mapToInt(a->a.getRewardsPoints()).sum());
				rewardsMonthly.add(currentMonth);
				
			}
			if(tranPreviousMonth1.size()>0) {
				Reward_Breakdown_Monthly currentMonth=new Reward_Breakdown_Monthly();			   
			    currentMonth.setMonth((simpleMonth.format(tranPreviousMonth1.get(0).getDate())));
				currentMonth.setPurchase_Total(tranPreviousMonth1.stream().mapToDouble(a->a.getPurchaseTotal()).sum());
				currentMonth.setRewards_Total(tranPreviousMonth1.stream().mapToInt(a->a.getRewardsPoints()).sum());
				rewardsMonthly.add(currentMonth);
			}
			if(tranPreviousMonth2.size()>0) {
				Reward_Breakdown_Monthly currentMonth=new Reward_Breakdown_Monthly();
			    currentMonth.setMonth((simpleMonth.format(tranPreviousMonth2.get(0).getDate())));
				currentMonth.setPurchase_Total(tranPreviousMonth2.stream().mapToDouble(a->a.getPurchaseTotal()).sum());
				currentMonth.setRewards_Total(tranPreviousMonth2.stream().mapToInt(a->a.getRewardsPoints()).sum());
				rewardsMonthly.add(currentMonth);
			}
			
			if(tranPreviousMonth3.size()>0) {
				Reward_Breakdown_Monthly currentMonth=new Reward_Breakdown_Monthly();
			    currentMonth.setMonth((simpleMonth.format(tranPreviousMonth3.get(0).getDate())));
				currentMonth.setPurchase_Total(tranPreviousMonth3.stream().mapToDouble(a->a.getPurchaseTotal()).sum());
				currentMonth.setRewards_Total(tranPreviousMonth3.stream().mapToInt(a->a.getRewardsPoints()).sum());
				rewardsMonthly.add(currentMonth);
			}
			
			
			customerRewards.setRewardsMonthly(rewardsMonthly);
			rewards.add(customerRewards);
		}
		rewardsDetail.setCustomer_Rewards(rewards);
		return rewardsDetail;
		
	}
}
