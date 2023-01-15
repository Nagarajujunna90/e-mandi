package com.emandi.customerservice.service;


import com.emandi.customerservice.model.Customer;

import java.util.List;

public interface CustomerService {

	void createUser(Customer userdto);
	void deleteUser(Integer id);
	Customer updateUser(Integer id, Customer userdto);
	public Customer findByUserId(Integer id);
	List<Customer> findAllUserDetails();

}
