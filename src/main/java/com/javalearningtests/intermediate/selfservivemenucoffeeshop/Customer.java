package com.javalearningtests.intermediate.selfservivemenucoffeeshop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Customer {
    private String customerName;
    private int customerPoints;


    public Customer(String customerName) {
        this.customerName = customerName;
        this.customerPoints = 0;
    }
}
