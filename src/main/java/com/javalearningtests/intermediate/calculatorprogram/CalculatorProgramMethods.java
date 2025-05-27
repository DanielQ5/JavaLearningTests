package com.javalearningtests.intermediate.calculatorprogram;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;


@Getter
@Setter

public class CalculatorProgramMethods {
    Scanner scanner = new Scanner(System.in);

    final static int DIVISION_NUMBER_NOT_SUPPORTED = 0;


    public static void mutiplicationMethod(Scanner scanner) {
        System.out.println("Please enter the first number to calculate:");
        BigDecimal firstNumber = new BigDecimal(scanner.nextLine());

        System.out.println("Please enter the second number to calculate:");
        BigDecimal secondNumber = new BigDecimal(scanner.nextLine());

        BigDecimal result = firstNumber.multiply(secondNumber);
        result = result.setScale(2, RoundingMode.HALF_UP);

        System.out.println("The result is: " + result);
    }

    public static void additionMethod(Scanner scanner) {
        System.out.println("Please enter the first number to calculate:");
        BigDecimal firstNumber = new BigDecimal(scanner.nextLine());

        System.out.println("Please enter the second number to calculate:");
        BigDecimal secondNumber = new BigDecimal(scanner.nextLine());

        BigDecimal result = firstNumber.add(secondNumber);
        result = result.setScale(2, RoundingMode.HALF_UP);

        System.out.println("The result is: " + result);
    }

    public static void substractionMethod(Scanner scanner) {
        System.out.println("Please enter the first number to calculate:");
        BigDecimal firstNumber = new BigDecimal(scanner.nextLine());

        System.out.println("Please enter the second number to calculate:");
        BigDecimal secondNumber = new BigDecimal(scanner.nextLine());

        BigDecimal result = firstNumber.subtract(secondNumber);
        result = result.setScale(2, RoundingMode.HALF_UP);

        System.out.println("The result is: " + result);
    }

    public static void divisionMethod(Scanner scanner) {
        System.out.println("Please enter the first number to calculate:");
        BigDecimal firstNumber = new BigDecimal(scanner.nextLine());

        boolean isZeroEntered = false;

        do {
            System.out.println("Please enter the second number to calculate:");
            BigDecimal secondNumber = new BigDecimal(scanner.nextLine());

            if (secondNumber.equals(BigDecimal.valueOf(DIVISION_NUMBER_NOT_SUPPORTED))) {
                System.out.println("A division by 0 is not supported, please try again!");
            } else {
                BigDecimal result = firstNumber.divide(secondNumber, 2, RoundingMode.HALF_UP);

                System.out.println("The result is: " + result);

                isZeroEntered = true;

            }
        } while (!isZeroEntered);
    }

    public static void powerMethod(Scanner scanner) {
        System.out.println("Please enter the first number to calculate:");
        BigDecimal firstNumber = new BigDecimal(scanner.nextLine());

        System.out.println("Please enter the number you want to power the first one to:");
        BigDecimal powerNumber = new BigDecimal(scanner.nextLine());

        BigDecimal powerResult = firstNumber.pow(Integer.parseInt(String.valueOf(powerNumber)));

        powerResult = powerResult.setScale(2, RoundingMode.HALF_UP);

        System.out.println("The result is: " + powerResult);
    }

    public static void squareCalculationMethod(Scanner scanner) {

        System.out.println("Please enter the number to calculate:");
        BigDecimal numberToCalculate = new BigDecimal(scanner.nextLine());

        BigDecimal sqrtCalculation = BigDecimal.valueOf(Math.sqrt(Double.parseDouble(String.valueOf(numberToCalculate))));

        sqrtCalculation = sqrtCalculation.setScale(2, RoundingMode.HALF_UP);

        System.out.println("The result is: " + sqrtCalculation);

    }

    public static void showMenu() {

        System.out.println("\nWhat action do you want to perform? : (Please choose an option from the menu)");
        System.out.println("1. I want to Add two numbers:");
        System.out.println("2. I want to Subtract two numbers:");
        System.out.println("3. I want to Multiply two numbers:");
        System.out.println("4. I want to Divide two numbers:");
        System.out.println("5. I want to raise Power of a number by another number:");
        System.out.println("6. I want to calculate the Square Root of a number:");
        System.out.println("7. I want to Exit:");

    }

    public static BigDecimal subtract(BigDecimal firstNumber, BigDecimal secondNumber) {
        BigDecimal result = firstNumber.subtract(secondNumber);
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal add(BigDecimal firstNumber, BigDecimal secondNumber) {
        BigDecimal result = firstNumber.add(secondNumber);
        return result.setScale(2, RoundingMode.HALF_UP);
    }

}
