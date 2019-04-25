package com.capg.banking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int Account_no;
	String first_name;
	String last_name;
	String email;
	String password;
	int pancard_no	;
	int aadhar_no	;
	String address	;
	int mobile_no;
	int balance	;
	public int getAccount_no() {
		return Account_no;
	}
	public void setAccount_no(int account_no) {
		Account_no = account_no;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPancard_no() {
		return pancard_no;
	}
	public void setPancard_no(int pancard_no) {
		this.pancard_no = pancard_no;
	}
	public int getAadhar_no() {
		return aadhar_no;
	}
	public void setAadhar_no(int aadhar_no) {
		this.aadhar_no = aadhar_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(int mobile_no) {
		this.mobile_no = mobile_no;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
public Customer() {
		
	}

	@Override
	public String toString() {
		return "Customer [Account_no=" + Account_no + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", password=" + password + ", pancard_no=" + pancard_no + ", aadhar_no="
				+ aadhar_no + ", address=" + address + ", mobile_no=" + mobile_no + ", balance=" + balance + "]";
	}
		
}





