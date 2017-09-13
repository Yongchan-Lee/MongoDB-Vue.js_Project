package com.example.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    
/*    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }*/
}
