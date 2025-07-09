package com.javalearningtests.intermediate.selfservicemenucoffeeshop;

/*Intermediate Java Test 3: Coffee Shop Kiosk – Menu with Switch Case, Enums & OOP
User Story:
As a coffee shop customer using a self-service kiosk,
I want to choose between ordering drinks, viewing store hours, checking loyalty points, or exiting,
so I can interact smoothly without staff help.

 **Detailed Acceptance Criteria**
Acceptance Criteria for Intermediate Test 3: Coffee Shop Order System (Using switch, OOP, and Interfaces)
Feature	Description
Menu System (switch-case)	User can choose from a list of drinks (e.g., Espresso, Latte, Cappuccino).
Clean Switch Usage	Use switch on either a String or enum. Must handle invalid inputs.
OOP Design	At least two classes, and one interface (e.g., Drink, OrderService).
Encapsulation	Keep drink logic (price, name, loyalty points) encapsulated.
Add to Cart Loop: Loop through multiple orders until the user exits.
Track Total Orders (New)	Keep a session count of all drinks ordered.
Simulate Loyalty Points (New)	Increment points per order and show points summary after each transaction.
Unit Test	Write one unit test validating price or loyalty point logic.
Input Validation	Graceful handling of typos or invalid selections.
Output Summary	After exit, show a summary of total orders, total cost, and loyalty points. */


import com.javalearningtests.intermediate.calculatorprogram.CalculatorProgramFileManager;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CoffeeShopKioskMain {


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("----------Welcome to you Favorite Coffee Shop Kiosk----------");

        Scanner scanner = new Scanner(System.in);
        CustomerActivities customerActivities = new CustomerActivities();
        CoffeeShopFileManager coffeeShopFileManager = new CoffeeShopFileManager();
        coffeeShopFileManager.getFileName();

        coffeeShopFileManager.loadKeyValuePairs(coffeeShopFileManager.getFileName(), customerActivities.getCustomersList());
        System.out.println("Loaded customers: " + customerActivities.getCustomersList());

        String customerId = customerActivities.addCustomer();
        Customer customer = new Customer(customerId);



        boolean isCustomerExiting = true;

        while (isCustomerExiting) {
            try {

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        customerActivities.orderBeverage(customerId);
                        customerActivities.showMenu();
                        break;

                    case 2:
                        customerActivities.displayCustomerPointsBalance(customerId);
                        customerActivities.showMenu();
                        break;

                    case 3:
                        customerActivities.paymentAndCheckout(customerId);
                        customerActivities.saveToFile(customerId, coffeeShopFileManager, customerActivities.getCustomersList(), customerActivities.getTotalCost());
                        coffeeShopFileManager.retrieveResult();
                        return;

                    default:
                        System.out.println("Try again. Please enter a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Entry not Supported, please try again!");
                customerActivities.showMenu();
                scanner.next();
            }
        }
    }
}
