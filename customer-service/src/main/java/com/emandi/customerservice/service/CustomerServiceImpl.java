package com.emandi.customerservice.service;


import com.emandi.customerservice.model.Customer;
import com.emandi.customerservice.model.Role;
import com.emandi.customerservice.repository.RoleRepository;
import com.emandi.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository userRepositroy;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void createUser(Customer customer) {
		List<Role> roles = roleRepository.findAll();
		Set<Role> roles1 =new HashSet<>();
		roles1.add(new Role("Admin"));
		customer.setRoles(roles1);
		Customer customer1 = userRepositroy.save(customer);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepositroy.deleteById(id);
		
	}

	@Override
	public Customer updateUser(Integer id, Customer customer) {
		customer.setId(id);
		customer.setUserName(customer.getUserName());
		customer.setPassword(customer.getPassword());
		customer.setFirstName(customer.getFirstName());
		customer.setLastName(customer.getLastName());
		customer.setFatherName(customer.getFatherName());
		customer.setQualification(customer.getQualification());
		return userRepositroy.save(customer);
	}

	@Override
	public Customer findByUserId(Integer id) {
		 Customer customer =userRepositroy.findById(id).orElse(null);
		return customer;
	}

	@Override
	public List<Customer> findAllUserDetails() {
    List<Customer>	userlist=(List<Customer>)userRepositroy.findAll();
		return userlist;
	}

}
