package com.javalearningtests.pruebasbasicas;//Objective:
//Implement the Bubble Sort algorithm to sort an array of numbers. The program should:
//
//1.Ask the user for the array size and elements.
//2.Implement Bubble Sort to sort the array in ascending order.
//3.Display each pass of the sorting process.
//4.Allow the user to search for a number in the sorted array using Binary Search (reusing your previous function).
//
// Bonus Challenge:
//1.Modify the algorithm to allow sorting in both ascending and descending order based on user choice.
//2.Display execution time for sorting.
//TODO Test how to swap two variables without the usage of a temp variable

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println("------- Welcome to your Bubble Sort Program -------");
        System.out.println("This program allows you to sort an array with the Bubble Sort");

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

        System.out.println("Great! These are the numbers you have entered: " + Arrays.toString(mainListArray));
        System.out.println("\nNext up, what would you like to do?: (Please choose an option)");

        System.out.println("1. I want to sort with Bubble Sort in Ascending Order:");
        System.out.println("2. I want to sort with Bubble Sort in Descending Order:");
        System.out.println("3. I want to search for an element: (Only after Sorting)");
        System.out.println("4. I want to Exit:");

        boolean loopValidation = true;
        while (loopValidation) {
            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        ascendingOrderBubbleSort(mainListArray);
                        break;
                    case 2:
                        descendingOrderBubbleSort(mainListArray);
                        break;
                    case 3:
                        binarySearch(mainListArray);
                        break;
                    case 4:
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

    public static void ascendingOrderBubbleSort(int[] mainListArray) {
        boolean swappedValidation = true;
        while (swappedValidation) {
            swappedValidation = false;
            for (int i = 0; i < mainListArray.length - 1; i++) {
                if (mainListArray[i] > mainListArray[i + 1]) {
                    swappedValidation = true;
                    int temp = mainListArray[i];
                    mainListArray[i] = mainListArray[i + 1];
                    mainListArray[i + 1] = temp;
                    System.out.println(Arrays.toString(mainListArray));
                }
            }
        }
        System.out.println("\nThis is the final sorted listed in ascending order: " + Arrays.toString(mainListArray));
        System.out.println("\nWhat do you want to do next? Please select an option:");
        System.out.println("3. I want to search for a number:");
        System.out.println("4. I want to Exit.");
    }

    public static void descendingOrderBubbleSort(int[] mainListArray) {
        boolean swappedValidation = true;
        while (swappedValidation) {
            swappedValidation = false;
            for (int i = 0; i < mainListArray.length - 1; i++) {
                if (mainListArray[i] < mainListArray[i + 1]) {
                    swappedValidation = true;
                    int temp = mainListArray[i];
                    mainListArray[i] = mainListArray[i + 1];
                    mainListArray[i + 1] = temp;
                    System.out.println(Arrays.toString(mainListArray));
                }
            }
        }
        System.out.println("\nThis is the final sorted listed in descending order: " + Arrays.toString(mainListArray));
        System.out.println("\nWhat do you want to do next? Please select an option:");
        System.out.println("3. I want to search for another number:");
        System.out.println("4. I want to Exit.");
    }

    public static void binarySearch(int[] mainListArray) {
        System.out.print("\nPlease enter the number you want to search:");
        Scanner scan = new Scanner(System.in);
        int numberToFind = scan.nextInt(); //
        int lowPointIndex = 0;
        int highPointIndex = mainListArray.length - 1;
        Arrays.sort(mainListArray);
        while (lowPointIndex <= highPointIndex) {

            int middlePosition = (lowPointIndex + highPointIndex) / 2;
            int middleNumber = mainListArray[middlePosition];

            if (numberToFind == middleNumber) {
                System.out.println("\nGreat news! We found the number: " + numberToFind + " at index #: " + middlePosition);
                System.out.println("\nWhat do you want to do next? Please select an option:");
                System.out.println("3. I want to search for another number:");
                System.out.println("4. I want to Exit.");
                return;

            } else if (lowPointIndex == highPointIndex) {
                System.out.println("\nWe're sorry, we didn't find your number");
                System.out.println("\nWhat do you want to do next? Please select an option:");
                System.out.println("3. I want to search for another number:");
                System.out.println("4. I want to Exit.");
                return;
            }
            if (numberToFind < middleNumber) { // Jump, since this condition is not met.
                highPointIndex = middlePosition - 1;

            } else {
                lowPointIndex = middlePosition + 1;
            }
        }
    }
}





