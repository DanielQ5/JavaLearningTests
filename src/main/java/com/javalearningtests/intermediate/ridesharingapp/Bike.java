package com.javalearningtests.intermediate.ridesharingapp;


public class Bike extends Vehicle {

    private static final float BASE_RATE_BIKE = 1.5f;

    public Bike(String unitId, String unitBrand, int numberOfWheels, int unitDoNotExceedSpeed) {
        super(unitId, unitBrand, numberOfWheels, unitDoNotExceedSpeed);
    }

    @Override
    public float calculateFare(int totalReservationTime) {


        float resultFare = BASE_RATE_BIKE * totalReservationTime;

        return resultFare;
    }
}
