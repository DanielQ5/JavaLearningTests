package com.javalearningtests.intermediate.ridesharingapp;

import lombok.Getter;

@Getter

public abstract class Vehicle {

    private String unitId;
    private String unitBrand;
    private int numberOfWheels;
    private int unitDoNotExceedSpeed;

    public Vehicle(String unitId, String unitBrand, int numberOfWheels, int unitDoNotExceedSpeed) {
        this.unitId = unitId;
        this.unitBrand = unitBrand;
        this.numberOfWheels = numberOfWheels;
        this.unitDoNotExceedSpeed = unitDoNotExceedSpeed;
    }

    public abstract float calculateFare(int totalReservationTime);

}
