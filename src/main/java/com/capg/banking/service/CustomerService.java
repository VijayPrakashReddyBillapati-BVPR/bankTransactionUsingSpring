package com.capg.banking.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.capg.banking.entity.Customer;


public interface CustomerService {

	public List<Customer> getCustomers();
	public int registerCustomers(Customer customer);
	public Customer getCustomer(int theId);
	public List<Customer> getCustomer(int accNo , String pass);
	public void deleteCustomer(int theId);
	public void updateCustomer(Customer cust);
	
	
}
