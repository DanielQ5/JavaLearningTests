package com.javalearningtests.intermediate.ridesharingapp;

public class ElectricScooter extends Vehicle implements EcoFriendly {

    private static final float BASE_RATE_SCOOTER = 5.5f;
    private static final float CARBON_REDUCTION = 0.8f;

    public ElectricScooter(String unitId, String unitBrand, int numberOfWheels, int unitDoNotExceedSpeed) {
        super(unitId, unitBrand, numberOfWheels, unitDoNotExceedSpeed);
    }

    @Override
    public void getCarbonFootprintReduction() {
        System.out.println("*Eco Friendly Option is Turned On*");
        System.out.println("This ride reduces carbon emissions by " + (CARBON_REDUCTION * 100) + "%");
    }

    @Override
    public float calculateFare(int totalReservationTime) {

        float resultFare = BASE_RATE_SCOOTER * totalReservationTime;

        return resultFare;
    }
}
