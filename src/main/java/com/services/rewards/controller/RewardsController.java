package com.services.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.rewards.model.Rewards;
import com.services.rewards.service.RewardsService;

@RestController
@RequestMapping("/service")
public class RewardsController {
	@Autowired
	RewardsService rewardsService;
	
	@GetMapping("/rewards")
	public Rewards getRewardsDetail() {
		return rewardsService.getAllRewardPointsperCustomer();
	}

}
