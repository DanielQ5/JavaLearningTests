package com.javalearningtests.intermediate.selfservivemenucoffeeshop;

import lombok.Getter;
import lombok.Setter;

@Getter

public enum Beverages {
    BLACK_COFFEE("Black Coffee", 2.50, 3),
    CAPPUCCINO("Cappuccino", 3.00, 5),
    LATTE("Caffe Latte",3.75, 7 ),
    ICED_TEA("Ice Tea", 4.15, 10);

    private final String displayBeverageType;
    private final double unitPrice;
    private final int customerLoyaltyPoints;

    Beverages(String displayBeverageType, double unitPrice, int customerLoyaltyPoints) {
        this.displayBeverageType = displayBeverageType;
        this.unitPrice = unitPrice;
        this.customerLoyaltyPoints = customerLoyaltyPoints;
    }


    @Override
    public String toString() {
        return displayBeverageType;
    }
}


