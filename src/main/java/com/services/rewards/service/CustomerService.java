package com.services.rewards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.rewards.model.Customer;
import com.services.rewards.repository.CustomerRepository;

@Service
public class CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	public void saveCustomer(String name,String email) {
		Customer customer=new Customer();
		customer.setEmail(email);
		customer.setName(name);
		customerRepository.save(customer);
	}
	
	public Customer customerById(Integer id) {
		Customer customer=customerRepository.findById(id).get();
		return customer;
	}
	
	public List<Customer> customers(){
		return customerRepository.findAll();
	}
	

}
