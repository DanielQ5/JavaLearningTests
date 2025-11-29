package com.javalearningtests.intermediate.ridesharingapp;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Customer {

    private String customerID;
    private String customerName;

    public Customer(String customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }
}
