package com.emandi.customerservice.service;


import com.emandi.customerservice.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CustomerService {

	User createUser(User userdto) throws JsonProcessingException;
	void deleteUser(Integer id);
	User updateUser(Integer id, User userdto);
	public User findByUserId(Integer id);
	List<User> findAllUserDetails();

}
