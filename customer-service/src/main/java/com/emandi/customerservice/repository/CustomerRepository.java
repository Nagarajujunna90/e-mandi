package com.emandi.customerservice.repository;


import com.emandi.customerservice.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {




	

}
