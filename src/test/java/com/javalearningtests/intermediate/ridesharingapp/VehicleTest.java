package com.javalearningtests.intermediate.ridesharingapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {

    @Test
    @DisplayName("Should correctly calculate fare for Car")
    void shouldCalculateRateForCar() {

        // Arrange
        Car car = new Car("TEST CAR", "TEST BRAND", 4, 100);
        int testCarRentalTime = 45;

        // Act
        float carRentalFare = car.calculateFare(testCarRentalTime);

        // Assert
        assertEquals(157.5f, carRentalFare);
    }

    @Test
    @DisplayName("Should correctly calculate fare for Bike")
    void shouldCalculateRateForBike() {

        // Arrange
        Bike bike = new Bike("TEST BIKE", "TEST BRAND", 2, 60);
        int testBikeRentalTime = 35;

        // Act
        float bikeRentalFare = bike.calculateFare(testBikeRentalTime);

        // Assert
        assertEquals(52.5f, bikeRentalFare);
    }

    @Test
    @DisplayName("Should correctly calculate fare for Electric Scooter")
    void shouldCalculateRateForScooter() {
        // Arrange
        ElectricScooter electricScooter = new ElectricScooter("TEST SCOOTER", "TEST BRAND", 2, 60);
        int testScooterRentalTime = 53;

        // Act
        float scooterRentalFare = electricScooter.calculateFare(testScooterRentalTime);

        // Assert
        assertEquals(291.5f, scooterRentalFare);
    }
}
