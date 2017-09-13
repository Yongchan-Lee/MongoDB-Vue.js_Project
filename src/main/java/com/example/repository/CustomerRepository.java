package com.example.repository;

import com.example.domain.Customer;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String>{

    //public Customer findByFirstName(String firstName);                //for MongadbCRUD.java
    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    public List<Customer> findAllByOrderByLastNameAsc();
}
