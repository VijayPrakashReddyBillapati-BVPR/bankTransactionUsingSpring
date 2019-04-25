package com.capg.banking.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capg.banking.entity.Customer;
import com.capg.banking.service.CustomerService;



@RestController
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	List<Customer> customers= new ArrayList<Customer>();
	
	@RequestMapping(value="/customers" , method=RequestMethod.GET)
	public List<Customer> listCustomers() {
		
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
		customers.addAll(theCustomers);
		
		return theCustomers ;
	}
	
	
	@RequestMapping(value="/customer" , method=RequestMethod.POST)
	public int registerCustomers(@RequestBody Customer customer) {
		
		// set customers to database
		int inserted=customerService.registerCustomers(customer);
		
		return inserted ;
	}
	
	@RequestMapping(value="/customer/{id}" , method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable  int id ){
		return customerService.getCustomer(id);
	}
	
	@RequestMapping(value="/withdraw/{accountNo}/{pass}/{amount}" , method=RequestMethod.PUT)
	public String withdraw(@PathVariable  int accountNo , @PathVariable  String pass, @PathVariable  int amount ){
		Customer cust= new Customer();
		cust=customerService.getCustomer(accountNo , pass);
		int balance=cust.getBalance();
		if(balance>amount)
		{
			balance-=amount;
			cust.setBalance(balance);
			customerService.updateCustomer(cust);
			
		}
		return "INR"+balance+" debited from Account Number "+accountNo+" on "+ java.time.LocalDateTime.now();
	}
	@RequestMapping(value="/deposit/{accountNo}/{pass}/{amount}" , method=RequestMethod.PUT)
	public String deposit(@PathVariable  int accountNo , @PathVariable  String pass, @PathVariable  int amount ){
		Customer cust= new Customer();
		cust=customerService.getCustomer(accountNo , pass);
		int balance=cust.getBalance();
		
			balance+=amount;
			cust.setBalance(balance);
			customerService.updateCustomer(cust);
			return "INR"+balance+" credited to Account Number "+accountNo+" on "+ java.time.LocalDateTime.now();
	}
	@RequestMapping(value="/balance/{accountNo}/{pass}" , method=RequestMethod.GET)
	public int showBalance(@PathVariable  int accountNo , @PathVariable  String pass){
		return customerService.getCustomer(accountNo , pass).getBalance();
		
	}
	
	@RequestMapping(value="/transfer/{accountNo}/{pass}/{accountNo}/{amount}" , method=RequestMethod.PUT)
	public String fundTransfer(@PathVariable  int accountNo , @PathVariable  String pass,@PathVariable  int amount, @PathVariable  int accountNo1 ){
		Customer cust= new Customer();
		Customer cust1= new Customer();
		List<Customer> custList= new ArrayList();
			custList=	customerService.getCustomer(accountNo , pass);
		cust.setBalance(custList.get(custList.indexOf(""))); 
		cust1=customerService.getCustomer(accountNo);
		int fromBalance=cust.getBalance();
		fromBalance-=amount;
		cust.setBalance(fromBalance);
		customerService.updateCustomer(cust);
		
		int toBalance=cust1.getBalance();
		toBalance+=amount;
		cust1.setBalance(toBalance);
		customerService.updateCustomer(cust1);
		
		return "INR"+fromBalance+" debited from Account Number "+accountNo+" and credited to "+accountNo1 +" on "+ java.time.LocalDateTime.now();
	}
	
	
}










