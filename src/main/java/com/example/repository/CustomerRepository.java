package com.example.repository;

import com.example.domain.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
    //@Autowired
    public Customer findByFirstName(String firstName);
    //@Autowired
    public List<Customer> findByLastName(String lastName);
    

}
