package com.capg.banking.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.capg.banking.entity.Customer;


@Repository
@EnableTransactionManagement
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional	
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}
	@Transactional
	public int registerCustomers(Customer customer) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
						
				// save the customer ... finally LOL
				currentSession.save(customer);		
		return 0;
	}
	
	@Transactional
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}
	
	@Transactional
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();		
	}
	@Transactional
	public List<Customer> getCustomer(int accNo, String pass)
	{
		// get the current hibernate session
		System.out.println(accNo+"<==========>"+pass);
		Session currentSession = sessionFactory.getCurrentSession();
						
				// create a query  ... sort by last name
				Query<Customer> theQuery = 
						currentSession.createQuery("from Customer where Account_no=:accNo and password =:pass" , Customer.class);
				theQuery.setParameter("accNo", accNo);
				theQuery.setParameter("pass", pass);
				List<Customer> customer =  new ArrayList();
				customer=theQuery.getResultList();
				// execute query and get result list
				return  customer;
	}
	@Transactional
	public void updateCustomer(Customer cust) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// save/upate the customer ... finally
		currentSession.saveOrUpdate(cust);
		
	}
}











