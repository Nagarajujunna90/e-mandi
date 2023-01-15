package com.emandi.customerservice.controller;


import com.emandi.customerservice.model.Customer;
import com.emandi.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody Customer customer) {
        customerService.createUser(customer);
        return new ResponseEntity<>("user inserted successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        customerService.deleteUser(id);
        return new ResponseEntity<>("user deleted successfully", HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Customer> updateUser(@PathVariable("id") Integer id, @RequestBody Customer customerDto) {
        Customer customer = customerService.updateUser(id, customerDto);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findByUserId(@PathVariable("id") Integer id) {
        Customer customer = customerService.findByUserId(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> findAllUsers() {
        List<Customer> userlist = customerService.findAllUserDetails();
        return new ResponseEntity<>(userlist, HttpStatus.OK);

    }
}
