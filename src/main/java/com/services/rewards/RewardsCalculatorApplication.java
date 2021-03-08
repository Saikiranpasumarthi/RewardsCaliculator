package com.services.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.services.rewards.model"})
public class RewardsCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardsCalculatorApplication.class, args);
	}

}
