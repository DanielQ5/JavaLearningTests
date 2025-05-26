package com.javalearningtests.pruebasbasicas;//Requirements:
//1.The user should input the size of the array and then enter the elements.
//2.The program should allow the user to input a number to search for in the array.
//3.Implement the Linear Search Algorithm to find the number.
//4.Display whether the number was found and at which index.
//5.Ensure proper handling of invalid inputs (non-integer values, out-of-bounds errors, etc.).
//6.The program should allow multiple searches without restarting.
//7.The user should have an option to exit.

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        System.out.println("------Welcome to your Number Finder Program!-------");
        System.out.println("This program allows you to create an Array & search for an element...");


        int arraySize = -1;

        Scanner scanner = new Scanner(System.in);

        while (arraySize <= 0) {
            try {
                System.out.print("\nPlease start by defining the size of the Array:");
                arraySize = scanner.nextInt();
                if (arraySize > 0) {
                    System.out.println("\nGreat! The size of the Array is: " + arraySize);
                } else {
                    System.out.println("Try again! The Array Size must be a positive Number.");
                }
            } catch (Exception e) {
                System.out.println("Invalid Entry, please try Again!");
                scanner.next();
            }
        }

        int[] mainListArray = new int[arraySize];

        System.out.println("\nNow, please enter the numbers to include in the data structure. " +
                "Remember you can only add " + arraySize + " numbers");

        for (int i = 0; i < arraySize; i++) {
            mainListArray[i] = scanner.nextInt();
        }
        System.out.println("\nGreat! These are the Elements you have submitted: " + Arrays.toString(mainListArray));

        System.out.println("What do you want to do? Please select an option:");
        System.out.println("1. I want to search for a number:");
        System.out.println("2. I want to Exit.");

        while (true) { //Loop que permite que la persona continue haciendo consultas hasta que seleccione salir
            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        findValue(mainListArray);
                        break;
                    case 2:
                        System.out.println("Thank you for using our program! Have a good day!");
                        return;
                    default:
                        System.out.println("Please enter a correct option.");
                }
            } catch (Exception exception) {
                System.out.println("Try Again! At the moment our program only supports numbers. No letters or special characters.");
                scanner.next();
            }

        }

    }

    public static void findValue(int[] mainListArray) {
        System.out.print("\nPlease enter the number you want to search:");
        Scanner scan = new Scanner(System.in);
        int lookUpValue = scan.nextInt();
        boolean numberFound = false;
        for (int j = 0; j < mainListArray.length; j++) {
            int i = mainListArray[j];
            if (i == lookUpValue) {
                numberFound = true;
                System.out.println("Your number has been found! It is located at index: " + j);
                break;
            }
        }
        if (!numberFound) {
            System.out.println("Your number was not found!");
        }
    }
}


