package com.javalearningtests.intermediate.selfservicemenucoffeeshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerActivitiesTest {

    private CustomerActivities customerActivities;
    private Map<String, Integer> testCustomersList;

    @BeforeEach
    void setUp() {
        customerActivities = new CustomerActivities();
        testCustomersList = new HashMap<>();
        // Set up a test customer
        testCustomersList.put("TEST123", 50); // Customer with 50 existing points
        customerActivities.setCustomersList(testCustomersList);
    }

    @Test
    @DisplayName("Should add loyalty points to total points earned")
    void shouldAddLoyaltyPointsToTotalPointsEarned() {
        // Arrange
        int initialPoints = customerActivities.getTotalPointsEarned();
        int beverageLoyaltyPoints = 3; // Black Coffee points

        // Act
        int returnedPoints = customerActivities.orderCustomerPointsTotal(beverageLoyaltyPoints);

        // Assert
        assertEquals(beverageLoyaltyPoints, returnedPoints);
        assertEquals(initialPoints + beverageLoyaltyPoints, customerActivities.getTotalPointsEarned());
    }

    @Test
    @DisplayName("Should add order total correctly for multiple drinks")
    void shouldAddOrderTotalMultipleBeverages() {
        // Arrange
        double lattePrice = 3.75;
        double icedTeaPrice = 4.15;
        double expectedTotalPrice = 11.65;

        // Act
        customerActivities.orderSubtotal(lattePrice);
        customerActivities.orderSubtotal(lattePrice);
        customerActivities.orderSubtotal(icedTeaPrice);

        //Assert
        assertEquals(expectedTotalPrice,customerActivities.getTotalCost(), 0.01);

    }


}
