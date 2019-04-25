package com.capg.banking.dao;

import java.util.List;

import com.capg.banking.entity.Customer;



public interface CustomerDAO {

	public List<Customer> getCustomers();
	public int registerCustomers(Customer customer);
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
	public List<Customer> getCustomer(int accNo, String pass);
	public void updateCustomer(Customer cust);
}
