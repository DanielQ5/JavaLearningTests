package com.javalearningtests.intermediate.ridesharingapp;

/*User Story

As a developer of a ride-sharing app, I want to model different types of vehicles (Car, Bike, ElectricScooter),
so that they all share common behaviors but can also have unique implementations.
This helps me manage vehicle operations in a scalable way.

Acceptance Criteria
Feature	Description

1. Abstract Base Class:Create an abstract class Vehicle with common fields (id, brand, speed) and abstract methods
(e.g., calculateFare(int distance)).
2. Interfaces: Create an interface EcoFriendly with a method getCarbonFootprintReduction(). Implement it in ElectricScooter.
3. Inheritance:	Car, Bike, and ElectricScooter extend Vehicle. Each overrides calculateFare differently.
4. Polymorphism: Demonstrate polymorphism by storing vehicles in a List<Vehicle> and calling calculateFare on each.
5. Unit Test: Write at least one JUnit test verifying fare calculation for different vehicles.
6. Encapsulation: Fields should be private with getters/setters where appropriate.
7. Input/Output: User can select vehicle type and distance, program outputs calculated fare.

Bonus (Optional)
Track total rides taken.
Apply loyalty discounts after multiple rides.
Add file logging of rides (vehicleId, time, fare).*/

import lombok.Getter;
import lombok.Setter;

import static com.javalearningtests.intermediate.ridesharingapp.DataBaseConfig.DATABASE_CONFIG_PATH;


public class RideSharingMain {

    public static void main(String[] args) {

        DataBaseConnectionManager dataBaseConnectionManager = new DataBaseConnectionManager(DATABASE_CONFIG_PATH);

        VehicleRentalUI vehicleRentalUI = new VehicleRentalUI();

        RentalDAO rentalDAO = new RentalDAO(dataBaseConnectionManager);

        RentalService rentalService = new RentalService(vehicleRentalUI, rentalDAO);

        rentalService.processNewRental();

    }
}
