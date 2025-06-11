package com.javalearningtests.intermediate.selfservivemenucoffeeshop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerActivities {


    private Map<String, Integer> customersList = new HashMap<>();
    Scanner scanner = new Scanner(System.in);


    public void addCustomer() {
        System.out.println("Hi! What's your name?");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);
        customersList.put(customerName, customer.getCustomerPoints());
        System.out.println("Hi " + customerName + " , Welcome!");

        System.out.println("We have stored your information: " + customersList);

    }

    public void showMenu() {
        System.out.println("\nWhat action do you want to perform? : (Please choose an option from the menu)");
        System.out.println("1. Order a Beverage");
        System.out.println("2. Check my Loyalty Points Balance:");
        System.out.println("3. Exit:");
    }
}
