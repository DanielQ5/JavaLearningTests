package com.javalearningtests.intermediate.selfservicemenucoffeeshop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CoffeeShopFileManager {

    private final String fileName = "src/main/java/com/javalearningtests/intermediate/selfservicemenucoffeeshop/past_orders.txt";

    public void logResult(String result) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            fileWriter.write(result);
            fileWriter.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
