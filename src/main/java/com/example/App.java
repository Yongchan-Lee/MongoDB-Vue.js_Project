package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;



/**
 * Hello world!
 *
 */
//@RestController
@SpringBootApplication
public class App implements CommandLineRunner {
    
    @Autowired
    CustomerRepository repository;
    
    @Override
    public void run(String... args) throws Exception {
     // save a couple of customers
        repository.save(new Customer(null, "Cal", "Smith"));
        repository.save(new Customer(null, "Dean", "Dean"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
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
        SpringApplication.run(App.class, args);
    }
}
