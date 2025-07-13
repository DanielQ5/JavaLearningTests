package com.javalearningtests.intermediate.selfservicemenucoffeeshop;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


@Getter
@Setter

public class CustomerActivities {

    public static final double INITIAL_COUNT = 0.0;
    public double totalCost = INITIAL_COUNT;
    public int totalPointsEarned = (int) INITIAL_COUNT;


    private Map<String, Integer> customersList = new HashMap<>();
    Scanner scanner = new Scanner(System.in);


    public String addCustomer() {
        String customerName;
        boolean isValidNameEntered = false;

        do {

            System.out.print("Hi! What's your name?");

            customerName = scanner.nextLine();

            if (customerName.isEmpty()) {
                System.out.print("Please enter your name, it cannot be blank! ");
            } else if (customerName.matches(".*\\d.*")) {
                System.out.println("Invalid input. The name cannot contain numbers!");
            } else {
                isValidNameEntered = true;
            }

        }while (!isValidNameEntered);

        System.out.println("\nHey " + customerName + " , Welcome!");

        System.out.print("Could you please provide your ID number?");

        String customerId = scanner.nextLine();

        if (customersList.containsKey(customerId)) {
            System.out.println("Welcome Back!");
        } else {
            Customer customer = new Customer(customerId);
            customersList.putIfAbsent(customerId, customer.getCustomerPoints());
            System.out.println("\nWe have added you to our Database!");
        }
        showMenu();

        return customerId;
    }

    public void showMenu() {
        System.out.println("\nSo, what action do you want to perform? : (Please choose an option from the menu)");
        System.out.println("1. Order a Beverage.");
        System.out.println("2. Check my Loyalty Points Balance.");
        System.out.println("3. Payment and Checkout.");
    }

    //TODO fix the map situation when reading and writing.

//    public void verifyCustomerFound ( Map<String, Integer> customersList, String customerId) {
//
//        if (customersList.containsKey(customerId)) {
//            System.out.println("Welcome Back!");
//        }
//    }

    public void orderBeverage(String customerId) {
        System.out.println("Which beverage can I get you today? ");

        displayAvailableBeverages();

        int beverageOption = scanner.nextInt();
        scanner.nextLine();


        switch (beverageOption) {
            case 1:
                Beverages blackCoffee = Beverages.BLACK_COFFEE;
                orderSubtotal(Beverages.BLACK_COFFEE.getUnitPrice());
                orderCustomerPointsTotal(Beverages.BLACK_COFFEE.getCustomerLoyaltyPoints());
                calculateCustomerPointsBalance(customerId, customersList, blackCoffee.getCustomerLoyaltyPoints());
            {
                System.out.println("Excellent Choice of a " + blackCoffee.getDisplayBeverageType() + "! That will be: " + "$" + blackCoffee.getUnitPrice());
                System.out.println("You have accumulated: " + blackCoffee.getCustomerLoyaltyPoints() + " points for your " + blackCoffee.getDisplayBeverageType() + ".");
            }
            break;

            case 2:
                Beverages latte = Beverages.LATTE;
                orderSubtotal(Beverages.LATTE.getUnitPrice());
                orderCustomerPointsTotal(Beverages.LATTE.getCustomerLoyaltyPoints());
                calculateCustomerPointsBalance(customerId, customersList, latte.getCustomerLoyaltyPoints());
            {
                System.out.println("You're about to enjoy a " + latte.getDisplayBeverageType() + ", splendid choice! That will be: " + "$" + latte.getUnitPrice());
                System.out.println("You have accumulated: " + latte.getCustomerLoyaltyPoints() + " points for your " + latte.getDisplayBeverageType() + ".");
            }
            break;

            case 3:
                Beverages icedTea = Beverages.ICED_TEA;
                orderSubtotal(Beverages.ICED_TEA.getUnitPrice());
                orderCustomerPointsTotal(Beverages.ICED_TEA.getCustomerLoyaltyPoints());
                calculateCustomerPointsBalance(customerId, customersList, icedTea.getCustomerLoyaltyPoints());
            {
                System.out.println("You chose an " + icedTea.getDisplayBeverageType() + ", great choice to fight this heat! That will be: " + "$" + icedTea.getUnitPrice());
                System.out.println("You have accumulated: " + icedTea.getCustomerLoyaltyPoints() + " points for your " + icedTea.getDisplayBeverageType() + ".");
            }
            break;

            case 4:
                Beverages cappuccino = Beverages.CAPPUCCINO;
                orderSubtotal(Beverages.CAPPUCCINO.getUnitPrice());
                orderCustomerPointsTotal(Beverages.CAPPUCCINO.getCustomerLoyaltyPoints());
                calculateCustomerPointsBalance(customerId, customersList, cappuccino.getCustomerLoyaltyPoints());
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
        orderTotal();
        customerPointsOrderTotal();
        System.out.println("Thank you for your business! Have a great day.");
    }

    public void saveToFile(String customerId, CoffeeShopFileManager fileManager, Map<String, Integer> customersList, double totalCost, int customerLoyaltyPoints) {

        String result = saveToFileTemplate(customerId, customersList, totalCost, customerLoyaltyPoints);

        fileManager.logResult(result);

    }

    public String saveToFileTemplate(String customerId, Map<String, Integer> customersList, double totalCost, int customerLoyaltyPoints) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("---------------------\n");
        stringBuilder.append("Purchase Entry for:(Customer ID:Loyalty Points)\n");
        stringBuilder.append(customerId).append(":").append(customersList.get(customerId)).append("\n");
        stringBuilder.append("Last Purchase Amount: $").append(totalCost).append("\n");
        stringBuilder.append("Points accumulated for last purchase: ").append(orderCustomerPointsTotal(customerLoyaltyPoints)).append("\n");

        return stringBuilder.toString();
    }


    public void orderSubtotal(double beveragesPrice) {

        ArrayList<Double> orderTotal = new ArrayList<>();

        orderTotal.add(beveragesPrice);
        totalCost += beveragesPrice;
    }

    public int orderCustomerPointsTotal(int customerLoyaltyPoints) {

        ArrayList<Integer> orderTotalPoints = new ArrayList<>();

        orderTotalPoints.add(customerLoyaltyPoints);
        totalPointsEarned += customerLoyaltyPoints;

        return customerLoyaltyPoints;
    }

    public void orderTotal() {
        System.out.println("Your order total is: $" + totalCost);
    }

    public void customerPointsOrderTotal() {
        System.out.println("You accumulated " + totalPointsEarned + " points with today's purchase!");

    }

    public int calculateCustomerPointsBalance(String customerId, Map<String, Integer> customersList, int customerLoyaltyPoints) {

        int pointsBeforePurchase = customersList.get(customerId);

        customersList.put(customerId, pointsBeforePurchase + customerLoyaltyPoints);

        int result = pointsBeforePurchase + customerLoyaltyPoints;

        return result;
    }

}
