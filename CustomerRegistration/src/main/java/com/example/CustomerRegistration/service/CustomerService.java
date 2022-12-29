package com.example.CustomerRegistration.service;

import com.example.CustomerRegistration.model.Customer;

import java.util.List;

public interface CustomerService {

	List < Customer > getAllCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomerById(int id);
	void deleteCustomerById(int id);
	boolean existsEmail(String email);
	boolean existsMobile(String mobile);

}