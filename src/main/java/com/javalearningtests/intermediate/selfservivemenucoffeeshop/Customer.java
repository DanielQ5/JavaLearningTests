package com.javalearningtests.intermediate.selfservivemenucoffeeshop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Customer {
    private String customerID;
    private String customerName;
    private int customerPoints;


    public Customer(String customerID) {
        this.customerID = customerID;
        this.customerPoints = 0;
    }
}
