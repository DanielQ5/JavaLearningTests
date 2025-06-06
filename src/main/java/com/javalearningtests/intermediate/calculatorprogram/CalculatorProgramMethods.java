package com.javalearningtests.intermediate.calculatorprogram;

import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


@Getter
@Setter

public class CalculatorProgramMethods {
    Scanner scanner = new Scanner(System.in);

    final static int DIVISION_NUMBER_NOT_SUPPORTED = 0;


    public static void multiplicationMethod(Scanner scanner, CalculatorProgramFileManager calculatorProgramFileManager) {
        BigDecimal[] numbersEntered = getTwoNumbers(scanner);

        BigDecimal result = numbersEntered[0].multiply(numbersEntered[1]);

        printAndLogResults(result, "Multiplication", calculatorProgramFileManager);
    }

    public static void additionMethod(Scanner scanner, CalculatorProgramFileManager calculatorProgramFileManager) {
        BigDecimal[] numbersEntered = getTwoNumbers(scanner);

        BigDecimal result = numbersEntered[0].add(numbersEntered[1]);

        printAndLogResults(result, "Addition", calculatorProgramFileManager);
    }

    public static void subtractionMethod(Scanner scanner, CalculatorProgramFileManager calculatorProgramFileManager) {
        BigDecimal[] numbersEntered = getTwoNumbers(scanner);

        BigDecimal result = numbersEntered[0].subtract(numbersEntered[1]);

        printAndLogResults(result, "Subtraction", calculatorProgramFileManager);
    }

    public static void divisionMethod(Scanner scanner, CalculatorProgramFileManager calculatorProgramFileManager) {
        BigDecimal firstNumber = getValidNumberInput(scanner, "Please enter the first number:");
        BigDecimal secondNumber = getValidDivisorInput(scanner);

        BigDecimal result = firstNumber.divide(secondNumber, 2, RoundingMode.HALF_UP);
        printAndLogResults(result, "Division", calculatorProgramFileManager);
    }

    public static void powerMethod(Scanner scanner, CalculatorProgramFileManager calculatorProgramFileManager) {

        BigDecimal firstNumber = getValidNumberInput(scanner, "Please enter the first number:");
        int secondNumber = validNumberForPowerInput(scanner, "Please enter the number you want to raise first number to:");
        BigDecimal result = firstNumber.pow(secondNumber);
        printAndLogResults(result, "Power", calculatorProgramFileManager);
    }

    public static void squareCalculationMethod(Scanner scanner, CalculatorProgramFileManager calculatorProgramFileManager) {

        BigDecimal numberToCalculate = getPositiveNumberSqrt(scanner, "Please enter the number to calculate:");

        BigDecimal result = calculateSquareRoot(numberToCalculate);

        printAndLogResults(result, "Square Root", calculatorProgramFileManager);
    }

    public static void showMenu() {

        System.out.println("\nWhat action do you want to perform? : (Please choose an option from the menu)");
        System.out.println("1. Add two numbers:");
        System.out.println("2. Subtract two numbers:");
        System.out.println("3. Multiply two numbers:");
        System.out.println("4. Divide two numbers:");
        System.out.println("5. Raise a Number to Power:");
        System.out.println("6. Calculate square root:");
        System.out.println("7. Exit:");

    }

//    public static BigDecimal subtract(BigDecimal firstNumber, BigDecimal secondNumber) {
//        BigDecimal result = firstNumber.subtract(secondNumber);
//        return result.setScale(2, RoundingMode.HALF_UP);
//    }
//
//    public static BigDecimal add(BigDecimal firstNumber, BigDecimal secondNumber) {
//        BigDecimal result = firstNumber.add(secondNumber);
//        return result.setScale(2, RoundingMode.HALF_UP);
//    }

    private static BigDecimal[] getTwoNumbers(Scanner scanner) {
        BigDecimal firstNumber = getValidNumberInput(scanner, "Please enter the first number to calculate:");
        BigDecimal secondNumber = getValidNumberInput(scanner, "Please enter the second number to calculate:");
        return new BigDecimal[]{firstNumber, secondNumber};
    }

    private static void printAndLogResults(BigDecimal result, String operation, CalculatorProgramFileManager calculatorProgramFileManager) {
        result = result.setScale(2, RoundingMode.HALF_UP);
        System.out.println("The result is: " + result);
        calculatorProgramFileManager.logResult(operation + " result is: " + result);
    }

    private static BigDecimal getValidNumberInput(Scanner scanner, String promptUser) {
        BigDecimal numberEntered = null;
        boolean validInputReceived = false;

        while (!validInputReceived) {
            try {
                System.out.println(promptUser);
                String userInput = scanner.nextLine();
                numberEntered = new BigDecimal(userInput);
                validInputReceived = true;
            } catch (NumberFormatException e) {
                System.out.println("Error, please enter a valid number.");
            }
        }
        return numberEntered;
    }

    private static BigDecimal getValidDivisorInput(Scanner scanner) {
        BigDecimal numberEntered;

        do {
            numberEntered = getValidNumberInput(scanner, "Please enter the second number:");

            if (numberEntered.equals(BigDecimal.valueOf(DIVISION_NUMBER_NOT_SUPPORTED))) {
                System.out.println("A division by 0 is not supported, please try again!");
            }
        } while (numberEntered.equals(BigDecimal.valueOf(DIVISION_NUMBER_NOT_SUPPORTED)));

        return numberEntered;

    }

    private static int validNumberForPowerInput(Scanner scanner, String prompt) {
        boolean isValidNumberEntered = false;
        int powerNumber = 0;

        while (!isValidNumberEntered) {
            try {
                System.out.println(prompt);
                String powerInput = scanner.nextLine().trim();
                powerNumber = Integer.parseInt(powerInput);
                isValidNumberEntered = true;
            } catch (NumberFormatException e) {
                System.out.println("Error. Please enter a valid Number to Raise Power");
            }
        }

        return powerNumber;
    }

    private static BigDecimal getPositiveNumberSqrt(Scanner scanner, String promptUser) {
        BigDecimal numberEntered;

        do {
            numberEntered = getValidNumberInput(scanner, promptUser);
            if (numberEntered.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("A number greater than Zero is required for Square Root Calculations");
            }
        } while (numberEntered.compareTo(BigDecimal.ZERO) < 0);

        return numberEntered;
    }

    private static BigDecimal calculateSquareRoot(BigDecimal number) {
        if (number.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }

        // Newton's method for square root
        BigDecimal x = number;
        BigDecimal y = number.add(BigDecimal.ONE).divide(BigDecimal.valueOf(2), 10, RoundingMode.HALF_UP);

        // Iterate until we reach desired precision
        while (y.compareTo(x) < 0) {
            x = y;
            y = x.add(number.divide(x, 10, RoundingMode.HALF_UP))
                    .divide(BigDecimal.valueOf(2), 10, RoundingMode.HALF_UP);
        }

        return x.setScale(2, RoundingMode.HALF_UP);
    }
}