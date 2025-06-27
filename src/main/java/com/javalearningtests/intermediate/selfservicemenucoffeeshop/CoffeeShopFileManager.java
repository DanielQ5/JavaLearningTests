package com.javalearningtests.intermediate.selfservicemenucoffeeshop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CoffeeShopFileManager {

    //TODO update filemanager to accurately store information on txt file

    CustomerActivities customerActivities = new CustomerActivities();

    private final String fileName = "src/main/java/com/javalearningtests/intermediate/selfservicemenucoffeeshop/past_orders.txt";

    public void logResult(String saveToFileTemplate) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            fileWriter.write(saveToFileTemplate);
            fileWriter.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
