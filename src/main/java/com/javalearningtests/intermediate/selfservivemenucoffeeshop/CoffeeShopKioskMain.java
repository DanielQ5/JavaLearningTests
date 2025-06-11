package com.javalearningtests.intermediate.selfservivemenucoffeeshop;

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


import java.util.Scanner;

public class CoffeeShopKioskMain {



    public static void main(String[] args) {
        System.out.println("----------Welcome to you Favorite Coffee Shop Kiosk----------");

        CustomerActivities customerActivities = new CustomerActivities();

        customerActivities.addCustomer();

        customerActivities.showMenu();

    }

}
