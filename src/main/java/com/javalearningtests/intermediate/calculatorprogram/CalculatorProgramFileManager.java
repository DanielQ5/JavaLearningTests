package com.javalearningtests.intermediate.calculatorprogram;

import java.io.*;
import java.util.Scanner;

public class CalculatorProgramFileManager {
    private final String fileName = "src/main/java/com/javalearningtests/intermediate/calculatorprogram/calculation_log.txt";

    public void logResult(String result) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            fileWriter.write(result);
            fileWriter.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
