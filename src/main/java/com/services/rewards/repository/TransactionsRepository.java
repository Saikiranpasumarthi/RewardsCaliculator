package com.services.rewards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.services.rewards.model.Customer;
import com.services.rewards.model.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer>{
	List<Transactions> findByCustomer (Customer customer);
}
