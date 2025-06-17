package com.javalearningtests.intermediate.selfservivemenucoffeeshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CustomerActivities {

    public static final double INITIAL_COUNT = 0.0;
    public double totalCost = INITIAL_COUNT;


    private Map<String, Integer> customersList = new HashMap<>();
    Scanner scanner = new Scanner(System.in);


    public String addCustomer() {

        System.out.print("Hi! What's your name?");

        String customerName = scanner.nextLine();

        System.out.println("\nHey " + customerName + " , Welcome!");

        System.out.print("Could you please provide your ID number?");

        String customerId = scanner.nextLine();

        Customer customer = new Customer(customerId);

        customersList.put(customerId, customer.getCustomerPoints());

        System.out.println("\nWe have added you to our Database!");

        showMenu();

        return customerId;
    }

    public void showMenu() {
        System.out.println("\nSo, what action do you want to perform? : (Please choose an option from the menu)");
        System.out.println("1. Order a Beverage.");
        System.out.println("2. Check my Loyalty Points Balance.");
        System.out.println("3. Payment and Checkout.");
    }

    public void orderBeverage(String customerId) {
        System.out.println("Which beverage can I get you today? ");

        displayAvailableBeverages();

        int beverageOption = scanner.nextInt();
        scanner.nextLine();


        switch (beverageOption) {
            case 1:
                Beverages blackCoffee = Beverages.BLACK_COFFEE;
                orderSubtotal(Beverages.BLACK_COFFEE.getUnitPrice());
                calculateCustomerPointsBalance(customerId, customersList, blackCoffee.getCustomerLoyaltyPoints());
            {
                System.out.println("Excellent Choice of a " + blackCoffee.getDisplayBeverageType() + "! That will be: " + "$" + blackCoffee.getUnitPrice());
                System.out.println("You have accumulated: " + blackCoffee.getCustomerLoyaltyPoints() + " points for your " + blackCoffee.getDisplayBeverageType() + ".");
            }
            break;

            case 2:
                Beverages latte = Beverages.LATTE;
                orderSubtotal(Beverages.LATTE.getUnitPrice());
            {
                System.out.println("You're about to enjoy a " + latte.getDisplayBeverageType() + ", splendid choice! That will be: " + "$" + latte.getUnitPrice());
                System.out.println("You have accumulated: " + latte.getCustomerLoyaltyPoints() + " points for your " + latte.getDisplayBeverageType() + ".");
            }
            break;

            case 3:
                Beverages icedTea = Beverages.ICED_TEA;
                orderSubtotal(Beverages.ICED_TEA.getUnitPrice());
            {
                System.out.println("You chose an " + icedTea.getDisplayBeverageType() + ", great choice to fight this heat! That will be: " + "$" + icedTea.getUnitPrice());
                System.out.println("You have accumulated: " + icedTea.getCustomerLoyaltyPoints() + " points for your " + icedTea.getDisplayBeverageType() + ".");
            }
            break;

            case 4:
                Beverages cappuccino = Beverages.CAPPUCCINO;
                orderSubtotal(Beverages.CAPPUCCINO.getUnitPrice());
            {
                System.out.println("Delicious " + cappuccino.getDisplayBeverageType() + " coming your way! That will be: " + "$" + cappuccino.getUnitPrice());
                System.out.println("You have accumulated: " + cappuccino.getCustomerLoyaltyPoints() + " points for your " + cappuccino.getDisplayBeverageType() + ".");
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

    public void displayCustomerPointsBalance(String customerId) {

        System.out.println("Certainly! So far you have accumulated: " + customersList.get(customerId) + " points.");
    }

    public void paymentAndCheckout() {
        double orderTotal = orderTotal();
        System.out.println("Thank you for your business! Have a great day.");
    }


    public void orderSubtotal(double beveragesPrice) {

        ArrayList<Double> orderTotal = new ArrayList<>();

        orderTotal.add(beveragesPrice);
        totalCost += beveragesPrice;
    }

    public double orderTotal() {
        System.out.println("Your order total is: $" + totalCost);

        return totalCost;
    }

    public String calculateCustomerPointsBalance(String customerId, Map<String, Integer> customersList, int customerLoyaltyPoints) {

        int pointsBeforePurchase = customersList.get(customerId);

        customersList.put(customerId, pointsBeforePurchase + customerLoyaltyPoints);

        return customerId;
    }

}
