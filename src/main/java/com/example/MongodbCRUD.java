/*package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;



*//**
 * Hello world!
 *
 *//*
//@RestController
@SpringBootApplication
public class MongodbCRUD implements CommandLineRunner {
    
    @Autowired
    CustomerRepository repository;
    
    @Override
    public void run(String... args) throws Exception {
     // save a couple of customers
        repository.save(new Customer(null, "Iran", "Bean"));
        repository.save(new Customer(null, "Jason", "pal"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();
        
        System.out.println("Customers found with findAll(new PageRequest(1, 2)):");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll(new PageRequest(1, 2))) {
            System.out.println(customer);
        }
        System.out.println();
        
        System.out.println("Customers found with findAllByOrderByLastNameAsc():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAllByOrderByLastNameAsc()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

    }
    
    public static void main( String[] args )
    {
        SpringApplication.run(MongodbCRUD.class, args);
    }
}
*/