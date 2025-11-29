package com.javalearningtests.intermediate.ridesharingapp;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VehicleRentalUI {

    Scanner scanner = new Scanner(System.in);

    public String getCustomerName() {

        String customerName;
        boolean isValidNameEntered = false;

        do {
            System.out.println("Welcome to your Favorite Rental Business!");
            System.out.print("What's your name?");

            customerName = scanner.nextLine().trim();

            if (customerName.isEmpty()) {
                System.out.println("Error!Name field cannot be blank. Try Again!");
            } else if (customerName.matches(".*\\d.*")) {
                System.out.println("Error!Name filed cannot contain numbers or special characters. Try Again!");

            } else {
                isValidNameEntered = true;
            }

        } while (!isValidNameEntered);
        return customerName;
    }

    public String getCustomerID() {

        String customerID;

        System.out.print("Could you please provide your ID number?");
        customerID = scanner.nextLine();

        customerID = specialCharacterValidation(customerID).trim();

        return customerID;
    }

    public String getVehicleSelection() {

        boolean isValidVehicleEntered = false;
        List<String> validVehicle = Arrays.asList("car", "bike", "scooter");
        String vehicleSelection;

        do {
            System.out.println("Please enter the name of the vehicle you want to choose:\nType \"Car\" , \"Bike\" or \"Scooter\" as preferred.");

            vehicleSelection = scanner.nextLine().trim().toLowerCase();

            if (vehicleSelection.isEmpty()) {
                System.out.print("Please enter the vehicle type, it cannot be blank! ");
            } else if (vehicleSelection.matches(".*\\d.*")) {
                System.out.println("Invalid input. The name cannot contain numbers!");
            } else if (validVehicle.contains(vehicleSelection)){
                isValidVehicleEntered = true;
            } else {
                System.out.println("Invalid option. Please enter 'Car', 'Bike', or 'Scooter'.");
            }

        } while (!isValidVehicleEntered);

        System.out.println("Great! You chose " + vehicleSelection + " as your option. Good choice!");

        return vehicleSelection;
    }

    public int getRentalTime() {

        int timeSelection = 0;
        boolean isValidTimeEntered = false;

        do {
            System.out.println("Please enter the amount of minutes you want to rent the vehicle for:");

            if (scanner.hasNextInt()) {  // Check BEFORE reading
                timeSelection = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (timeSelection <= 0) {
                    System.out.println("Error! Time must be positive. Try again.");
                } else {
                    isValidTimeEntered = true;
                }
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine(); // Clear the invalid input
            }

        } while (!isValidTimeEntered);

        System.out.println("Thank you! Please proceed to Payment.");

        return timeSelection;
    }


    public String getPaymentMethod(int amountDue) {

        System.out.println("You are due: $" + amountDue + "\n How do you want to pay?");

        String paymentType;
        boolean isValidPaymentTypeEntered = false;
        List<String> validPayment = Arrays.asList("credit card", "cash", "etransfer");

        do {
            System.out.println("Please enter the method of payment:\nType \"Credit Card\" , \"Cash\" or \"eTransfer\" as preferred.");

            paymentType = scanner.nextLine().trim().toLowerCase();

            if (paymentType.isEmpty()) {
                System.out.print("Please enter a payment method, it cannot be blank! ");
            } else if (paymentType.matches(".*\\d.*")) {
                System.out.println("Invalid input. The name cannot contain numbers!");
            } else if (validPayment.contains(paymentType)) {
                isValidPaymentTypeEntered = true; // Set flag to true to exit the loop
            } else {
                System.out.println("Invalid option. Please enter 'Credit Card', 'Cash', or 'eTransfer'.");
            }

        } while (!isValidPaymentTypeEntered);

        return paymentType;
    }


    public String specialCharacterValidation(String customerIdValidation) {
        boolean isValidIdEntered = false;

        do {

            if (customerIdValidation.matches("^[a-zA-Z0-9_]+$")) {
                isValidIdEntered = true;
            } else {
                System.out.println("Please try Again. No special characters are allowed.");
                System.out.print("Could you please provide your ID number?");
                customerIdValidation = scanner.nextLine();
            }

        } while (!isValidIdEntered);
        return customerIdValidation;
    }
}

