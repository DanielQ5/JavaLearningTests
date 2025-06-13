package com.javalearningtests.intermediate.selfservivemenucoffeeshop;

import javax.xml.transform.Source;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerActivities {


    private Map<String, Integer> customersList = new HashMap<>();
    Scanner scanner = new Scanner(System.in);


    public void addCustomer() {

        System.out.print("Hi! What's your name?");

        String customerName = scanner.nextLine();

        System.out.println("\nHi " + customerName + " , Welcome!");

        System.out.print("Could you please provide your ID number?");

        String customerId = scanner.nextLine();

        Customer customer = new Customer(customerId);

        customersList.put(customerId, customer.getCustomerPoints());

        System.out.println("\nWe have added you to our Database!");

        showMenu(customerName);

    }

    public void showMenu(String customerName) {
        System.out.println("\nSo " + customerName + ", what action do you want to perform? : (Please choose an option from the menu)");
        System.out.println("1. Order a Beverage.");
        System.out.println("2. Check my Loyalty Points Balance.");
        System.out.println("3. Exit.");
    }

    public void orderBeverage() {
        System.out.println("Which beverage can I get you today? ");

        displayAvailableBeverages();

        int beverageOption = scanner.nextInt();
        scanner.nextLine();

        switch (beverageOption) {
            case 1:
                Beverages blackCoffee = Beverages.BLACK_COFFEE;
            {
                System.out.println("Excellent Choice of a " + blackCoffee.getDisplayBeverageType()+ "! That will be: " + "$" + blackCoffee.getUnitPrice());
            }
            break;

            case 2:
                Beverages latte = Beverages.LATTE;
            {
                System.out.println("You're about to enjoy a " + latte.getDisplayBeverageType() + ", splendid choice! That will be: " + "$" + latte.getUnitPrice());
            }
            break;

            case 3:
                Beverages icedTea = Beverages.ICED_TEA;
            {
                System.out.println("You chose an " + icedTea.getDisplayBeverageType() + ", great choice to fight this heat! That will be: " + "$" + icedTea.getUnitPrice());
            }
            break;

            case 4:
                Beverages cappuccino = Beverages.CAPPUCCINO;
            {
                System.out.println("Delicious " + cappuccino.getDisplayBeverageType() + " coming your way! That will be: " + "$" + cappuccino.getUnitPrice());
            }

        }
    }

    public void displayAvailableBeverages() {
        System.out.println("Please choose a beverage from the menu:");

        System.out.println("1." + Beverages.BLACK_COFFEE);
        System.out.println("2." + Beverages.LATTE);
        System.out.println("3." + Beverages.ICED_TEA);
        System.out.println("4." + Beverages.CAPPUCCINO);
    }

}
