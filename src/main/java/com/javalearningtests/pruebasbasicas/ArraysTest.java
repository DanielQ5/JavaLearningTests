package com.javalearningtests.pruebasbasicas;//Instructions
//Write a Java program that allows the user to perform the following operations on an array of integers:
//
//1.Initialize an Array: Allow the user to input the size of the array and fill it with numbers.
//2.Find the Maximum Value: Implement a method to find and return the largest number in the array.
//3.Calculate the Average: Create a method that calculates and returns the average of the numbers in the array.
//4.Search for an Element: Implement a method that searches for a specific number in the array and
// tells the user whether it is present and at which index(es).
//5.Display the Array: Print all elements in the array.
//6.Exit: Exit the program.
//Requirements
//1.Use a menu to allow the user to select which operation they want to perform.
//2.Validate all user inputs to ensure they are within appropriate ranges or valid
// (e.g., size of the array must be positive).
//3.Use methods for each operation to separate logic.
//4.Allow the user to perform multiple operations until they choose to exit.

//Arraylist do not have a specific size, it grows and shrinks automatically.
//Arrays have a set size.

import java.util.Arrays;
import java.util.Scanner;

public class ArraysTest {

    public static void main(String[] args) {

        System.out.println("-------Welcome to your Friendly Data Structure Calculator---------");

        System.out.println("\nWith this program, you are able to perform multiple actions.");
        System.out.println("To start, please choose the size of the data structure: ");

        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        while (arraySize < 0) {
            System.out.println("Sorry, at the moment you can only enter positive numbers. Try again");
            arraySize = scanner.nextInt();
        }

        int[] mainListArray = new int[arraySize];

        System.out.println("\nGreat, the data structure contains " + arraySize + " numbers!");

        System.out.println("\nNow, please enter the numbers to include in the data structure. " +
                "Remember you can only add " + arraySize + " numbers");

        for (int i = 0; i < arraySize; i++) {
            mainListArray[i] = scanner.nextInt();
        }

        System.out.println("\nAwesome! What calculation do you want to make?");
        System.out.println("1. Find the Maximum Value");
        System.out.println("2. Calculate the Average");
        System.out.println("3. Search for an Element");
        System.out.println("4. Display the Array");
        System.out.println("5. Exit");

        while (true) { //Loop que permite que la persona continue haciendo consultas hasta que seleccione salir
            try {
                int menuOptionSelection = scanner.nextInt();

                switch (menuOptionSelection) {
                    case 1:
                        findMaxValue(mainListArray);
                        break;
                    case 2:
                        calculateAverage(mainListArray);
                        break;
                    case 3:
                        searchElement(mainListArray);
                        break;
                    case 4:
                        displayArray(mainListArray);
                        break;
                    case 5:
                        System.out.println("Thank you for using our program! Have a good day!");
                        return;
                    default:
                        System.out.println("Please enter a correct option.");
                }

            } catch (Exception e) {
                System.out.println("Try Again! At the moment our program only supports numbers. No letters or special characters.");
                scanner.next();
            }
        }
    }

    public static void findMaxValue(int[] mainListArray) {
        int maxValue = mainListArray[0];
        for (int i : mainListArray) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        System.out.println("The largest number you have entered is : " + maxValue);
    }

    public static void calculateAverage(int[] mainListArray) {
        double sum = 0;
        int lengthArray = mainListArray.length;
        for (int i : mainListArray) {
            sum += i;
        }
        double average = sum / lengthArray;

        System.out.println("The average of the numbers you have entered is : " + average);
    }

    public static void searchElement(int[] mainListArray) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input the number you want to search :");
        int inquiredNumber = scan.nextInt();
        boolean numberFound = false;
        //{1, 2, 3, 4, 6} (the inquired number = 5)
        //{0, 1, 2, 3, 4}
        for (int j = 0; j < mainListArray.length; j++) {
            int i = mainListArray[j];
            if (i == inquiredNumber) {
                numberFound = true;
                System.out.println("Your number has been found! It is located in index: " + j);
                break;
            } else {
                if (mainListArray.length == j + 1) {
                    System.out.println("Your number was not found!");
                }
            }
        }
    }

    public static void displayArray(int[] mainListArray) {
        System.out.println("\nCertainly! This is the Data Structure Elements you have submitted: " + Arrays.toString(mainListArray));
    }

}


