package com.example.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
    @Autowired
    CustomerRepository customerRepository;
    
    //findAll customers
/*    @RequestMapping(method = RequestMethod.GET)
    List<Customer> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }*/
    
    //findAll customers using Pageable
    @RequestMapping(method = RequestMethod.GET)
    Page<Customer> getCustomers(@PageableDefault Pageable pageable) {
        Page<Customer> customers = customerRepository.findAll(pageable);
        return customers;
    }
    
    @RequestMapping(value = "lastName/{lastName}", method = RequestMethod.GET)
    List<Customer> getCustomersByLastName(@PathVariable String lastName) {
        List<Customer> customersByLastName = customerRepository.findByLastName(lastName);
        return customersByLastName;
    }
    
    @RequestMapping(value = "firstName/{firstName}", method = RequestMethod.GET)
    List<Customer> getCustomersByFirstName(@PathVariable String firstName) {
        List<Customer> customersByFirstName = customerRepository.findByFirstName(firstName);
        return customersByFirstName;
    }
    
    //New Customer Register
/*    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)                                                                 //return 201 CREATED if failed return 200 OK
    Customer postCustomers(@RequestBody Customer customer) {
        return customerRepository.insert(customer);
    }*/
    //Location Header
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Customer> postCustomers(@RequestBody Customer customer, UriComponentsBuilder uriBuilder) {
        Customer created = customerRepository.insert(customer);
        URI location = uriBuilder.path("api/customers/{id}").buildAndExpand(created.getId()).toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
    }
    
    //Customer Information Update : Failed... because of _id
    @RequestMapping(value = "firstName/{firstName}", method = RequestMethod.PUT)
    Customer putCustomer(@PathVariable String firstName, @RequestBody Customer customer) {
        customer.setFirstName(firstName);
        return customerRepository.save(customer);
    }
    
    //Customer Information Delete : Failed... because of _id
    @RequestMapping(value = "firstName/{firstName}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)                                                              //return 204 NO_CONTENT
    void deleteCustomer(@PathVariable String firstName) {
        customerRepository.delete(firstName);
    }
}
