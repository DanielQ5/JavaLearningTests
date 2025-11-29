package com.javalearningtests.intermediate.ridesharingapp;

public class Car extends Vehicle {

    private static final float BASE_RATE_CAR = 3.5f;

    public Car(String unitId, String unitBrand, int numberOfWheels, int unitDoNotExceedSpeed) {
        super(unitId, unitBrand, numberOfWheels, unitDoNotExceedSpeed);
    }

    @Override
    public float calculateFare(int totalReservationTime) {


        float resultFare = BASE_RATE_CAR * totalReservationTime;

        return resultFare;
    }
}
