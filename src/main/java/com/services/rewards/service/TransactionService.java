package com.services.rewards.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.rewards.model.Transactions;
import com.services.rewards.repository.TransactionsRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionsRepository transactionsRepository;
	@Autowired
	CustomerService customerService;
	@Autowired
	RewardsService rewardsService;
	
	public List<Transactions> transactionsByCustomer(Integer custId){
		return transactionsRepository.findByCustomer(customerService.customerById(custId));
	}
	
	
	public Transactions transactionsById(Integer id){
		return transactionsRepository.findById(id).get();
	}
	
	public List<Transactions> transactions(){
		return transactionsRepository.findAll();
	}
	
	public void saveTransaction(Integer customerId,Double purchaseTotal) {
		Transactions tran=new Transactions();
		tran.setCustomer(customerService.customerById(customerId));
		tran.setPurchaseTotal(purchaseTotal);
		tran.setDate(new Date());
		tran.setRewardsPoints(rewardsService.getPoints(purchaseTotal));
		transactionsRepository.save(tran);
		
	}
	
}
