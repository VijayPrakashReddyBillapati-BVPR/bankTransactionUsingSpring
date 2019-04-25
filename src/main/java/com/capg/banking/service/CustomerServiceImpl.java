package com.capg.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.banking.dao.CustomerDAO;
import com.capg.banking.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
	@Transactional
	public int registerCustomers(@RequestBody Customer customer)
	{
		return customerDAO.registerCustomers(customer);
	}
	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
	}
	@Transactional
	public void deleteCustomer(int theId) {
		 customerDAO.deleteCustomer(theId);
	}
	@Transactional
	public List<Customer> getCustomer(int accNo , String pass)
	{
		
		return customerDAO.getCustomer(accNo , pass);
	}
	@Transactional
	public void updateCustomer(Customer cust) {
		
		customerDAO.updateCustomer(cust);
	}
	
}





