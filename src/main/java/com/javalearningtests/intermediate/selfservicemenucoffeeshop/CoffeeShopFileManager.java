package com.javalearningtests.intermediate.selfservicemenucoffeeshop;

import lombok.Getter;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Getter

public class CoffeeShopFileManager {


    //TODO update filemanager to accurately store information on txt file

    CustomerActivities customerActivities = new CustomerActivities();

    private final int FILE_READER_END_CONFIRMATION = -1;
    private final String fileName = "src/main/java/com/javalearningtests/intermediate/selfservicemenucoffeeshop/past_orders.txt";

    public void logResult(String saveToFileTemplate) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            fileWriter.write(saveToFileTemplate);
            fileWriter.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public String retrieveResult() {
        String retrievedData = null;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

            while ((retrievedData = fileReader.readLine()) != null) {
                System.out.println(retrievedData);
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            //TODO more robust exception handling
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retrievedData;
    }


    public void loadKeyValuePairs(String fileName, Map<String, Integer> customersList) throws FileNotFoundException {
        try (BufferedReader readerToLoad = new BufferedReader(new FileReader(fileName))) {
            String lineReader;
            while ((lineReader = readerToLoad.readLine()) != null) {
                String[] mapParts = lineReader.split(":");
                if (mapParts.length == 2) {
                    String key = mapParts[0].trim();
                    String valueStr = mapParts[1].trim();

                    if (valueStr.startsWith("$")) {
                        continue;
                    }
                    int value = Integer.parseInt(valueStr);
                    customersList.put(key, value);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, Integer> readLoyaltyPointsFromFile(String fileName) throws IOException {
        Map<String, Integer> tempMapForCalculatingLoyaltyPoints = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String lineToRead = scanner.nextLine();
                String[] tempParts = lineToRead.split(":");
                if (tempParts.length == 2) {
                    String customerId = tempParts[0].trim();
                    customerId = tempParts[0].trim();
                    int pointsToCalculate = Integer.parseInt(tempParts[1].trim());
                    tempMapForCalculatingLoyaltyPoints.put(customerId, pointsToCalculate);
                }
            }
        }
        return tempMapForCalculatingLoyaltyPoints;
    }


    public Map<String, Integer> tempMapForCalculatingAndUpdatingPoints(String customerId, int customerLoyaltyPoints) {
        try {
            Map<String, Integer> retrieveAndUpdateLoyaltyPoints = readLoyaltyPointsFromFile(fileName);


            if (retrieveAndUpdateLoyaltyPoints.containsKey(customerId)) {
                int currentPoints = retrieveAndUpdateLoyaltyPoints.get(customerId);
                retrieveAndUpdateLoyaltyPoints.put(customerId, currentPoints + customerLoyaltyPoints);

            } else {
                retrieveAndUpdateLoyaltyPoints.put(customerId, customerLoyaltyPoints);
            }
            writeUpdatedLoyaltyPoints(retrieveAndUpdateLoyaltyPoints);
            return retrieveAndUpdateLoyaltyPoints;

        } catch (IOException e) {
            System.out.println("Error reading loyalty points: " + e.getMessage());
            return new HashMap<>();
        }
    }

    private void writeUpdatedLoyaltyPoints(Map<String, Integer> loyaltyPointsMap) {
        try (BufferedWriter updatedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Integer> updatedEntry : loyaltyPointsMap.entrySet()) {
                updatedWriter.write(updatedEntry.getKey() + ":" + updatedEntry.getValue());
                updatedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

