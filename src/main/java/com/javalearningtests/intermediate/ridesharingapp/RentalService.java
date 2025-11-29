package com.javalearningtests.intermediate.ridesharingapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalService {


    private VehicleRentalUI rentalUI;
    private RentalDAO rentalDAO;
    private List<Vehicle> availableVehicles;

    public RentalService(VehicleRentalUI rentalUI, RentalDAO rentalDAO) {
        this.rentalUI = rentalUI;
        this.rentalDAO = rentalDAO;
        this.availableVehicles = new ArrayList<>();

        initializeVehicles();
    }


    private void initializeVehicles() {
        availableVehicles.add(new Car("CAR001", "Toyota", 4, 250));
        availableVehicles.add(new Bike("BIKE001", "Corsario", 2, 80));
        availableVehicles.add(new ElectricScooter("SCOOTER001", "Tesla", 2, 90));

    }

    public List<Vehicle> getAvailableVehicles() {
        return availableVehicles;
    }

    private Vehicle getVehicleByType(String vehicleType) {
        // Loop through each vehicle in availableVehicles
        for (Vehicle vehicle : availableVehicles) {


            if (vehicleType.equalsIgnoreCase("car") && vehicle instanceof Car) {
                return vehicle;
            } else if (vehicleType.equalsIgnoreCase("bike") && vehicle instanceof Bike) {
                return vehicle;
            } else if (vehicleType.equalsIgnoreCase("scooter") && vehicle instanceof ElectricScooter) {
                return vehicle;
            }

        }

        // If nothing matched, return null
        return null;
    }

    public void processNewRental() {

        String customerName = rentalUI.getCustomerName();

        String customerId = rentalUI.getCustomerID();

        String vehicleSelection = rentalUI.getVehicleSelection();

        Vehicle selectedVehicle = getVehicleByType(vehicleSelection);

        int rentalTime = rentalUI.getRentalTime();

        float fareToChargeCustomer = selectedVehicle.calculateFare(rentalTime);

        if (selectedVehicle instanceof EcoFriendly) {
            ((EcoFriendly) selectedVehicle).getCarbonFootprintReduction();
        }

        // 7: Get payment method
        String paymentMethod = rentalUI.getPaymentMethod((int) fareToChargeCustomer);

        // 8: Save to database
        boolean isDataSaved = rentalDAO.insertRental(customerId, customerName, vehicleSelection, rentalTime, fareToChargeCustomer);

        // 9: Show confirmation message (inline, not separate method)
        if (isDataSaved) {
            System.out.println("✓ Rental complete for " + customerName + "! Enjoy your ride!");
        } else {
            System.out.println("✗ Error: Rental process incomplete. Please try again.");

        }

    }
}




