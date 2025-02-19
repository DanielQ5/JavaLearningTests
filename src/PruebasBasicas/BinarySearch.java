//Objective:
//Implement a Binary Search algorithm that efficiently finds an element in a sorted array.
//
//Requirements:
//Prompt the user to enter the size of the array.
//Accept only positive integers for the array size.
//Allow the user to enter elements of the array and automatically sort them.
//Ask the user to input a number to search for.
//Implement Binary Search to find the number.
//Display whether the number was found and its index.
//If the number is not found, display an appropriate message.
//Include proper exception handling for invalid inputs.
//Allow the user to search multiple times until they choose to exit.

package PruebasBasicas;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        System.out.println("------Welcome to your Binary Search Number Finder Program!-------");
        System.out.println("This program allows you to create an Array & search for an element.");

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
        Arrays.sort(mainListArray);

        System.out.println("\nGreat! These are the Elements you have submitted: " + Arrays.toString(mainListArray));
        System.out.println("Note: Since we are applying a Binary Search, our program has already pre-sorted them in ascending order.");

        System.out.println("\nWhat do you want to do? Please select an option:");
        System.out.println("1. I want to search for a number:");
        System.out.println("2. I want to Exit.");

        while (true) { //Loop que permite que la persona continue haciendo consultas hasta que seleccione salir
            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        binarySearch(mainListArray);
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

    public static void binarySearch(int[] mainListArray) {
        System.out.print("\nPlease enter the number you want to search:");
        Scanner scan = new Scanner(System.in);
        Arrays.sort(mainListArray);
        int numberToFind = scan.nextInt(); //
        int lowPointIndex = 0;
        int highPointIndex = mainListArray.length - 1;

        while (lowPointIndex <= highPointIndex) {

            int middlePosition = (lowPointIndex + highPointIndex) / 2;
            int middleNumber = mainListArray[middlePosition];

            if (numberToFind == middleNumber) {
                System.out.println("\nGreat news! We found the number: " + numberToFind + " at index #: " + middlePosition);
                System.out.println("\nWhat do you want to do next? Please select an option:");
                System.out.println("1. I want to search for another number:");
                System.out.println("2. I want to Exit.");

            }
            else if (lowPointIndex == highPointIndex){ //
                System.out.println("We're sorry, we didn't find your number");
                return;
            }

            if (numberToFind < middleNumber) { // Jump, since this condition is not met.
                highPointIndex = middlePosition ;

            } else {
                lowPointIndex = middlePosition + 1;
            }

        }
    }

}









