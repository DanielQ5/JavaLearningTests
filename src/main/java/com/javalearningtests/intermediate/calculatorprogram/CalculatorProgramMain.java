package com.javalearningtests.intermediate.calculatorprogram;


import java.util.Scanner;

public class CalculatorProgramMain {
    public static void main(String[] args) {
        System.out.println("----------Calculator Program----------");
        System.out.println("This program allows you to make calculations and log results into a file for future handling");

        Scanner scanner = new Scanner(System.in);
        CalculatorProgramFileManager calculatorProgramFileManager = new CalculatorProgramFileManager();

        CalculatorProgramMethods.showMenu();

        boolean continueLoop = true;

        while (continueLoop) {

            try {

                int menuSelection = scanner.nextInt();
                scanner.nextLine();

                switch (menuSelection) {
                    case 1:
                        CalculatorProgramMethods.additionMethod(scanner, calculatorProgramFileManager);
                        CalculatorProgramMethods.showMenu();
                        break;

                    case 2:
                        CalculatorProgramMethods.subtractionMethod(scanner, calculatorProgramFileManager);
                        CalculatorProgramMethods.showMenu();
                        break;

                    case 3:
                        CalculatorProgramMethods.multiplicationMethod(scanner, calculatorProgramFileManager);
                        CalculatorProgramMethods.showMenu();
                        break;

                    case 4:
                        CalculatorProgramMethods.divisionMethod(scanner, calculatorProgramFileManager);
                        CalculatorProgramMethods.showMenu();
                        break;

                    case 5:
                        CalculatorProgramMethods.powerMethod(scanner, calculatorProgramFileManager);
                        CalculatorProgramMethods.showMenu();
                        break;

                    case 6:
                        CalculatorProgramMethods.squareCalculationMethod(scanner, calculatorProgramFileManager);
                        CalculatorProgramMethods.showMenu();
                        break;

                    case 7:
                        System.out.println("Thank you for using our program. Have a great day!");
                        return;

                    default:
                        System.out.println("Try again. Please enter a valid option from the menu");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid input");
                CalculatorProgramMethods.showMenu();
                scanner.next();
            }
        }
    }
}
