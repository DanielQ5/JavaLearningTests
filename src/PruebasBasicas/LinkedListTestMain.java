/*Objective:
Understand and implement Linked Lists in Java, covering insertion, deletion, and traversal operations.

Requirements:
Create a LinkedList class that includes:

A nested Node class with data and a reference to the next node.
Methods for inserting a new node at the beginning, at the end, and at a specific position.
Methods for deleting a node by value and by position.
A method for traversing and printing all elements in the list.
Implement a menu-driven program that allows the user to:

Add elements (at the start, at the end, or at a position).
Remove elements (by value or by position).
Display the list.
Exit the program.
Bonus Challenge:
Implement a method to reverse the linked list.
Implement a search function that returns the position of a given element in the list.*/

package PruebasBasicas;
import java.util.Scanner;


public class LinkedListTestMain {

    public static void main(String[] args) {
        System.out.println("------- Welcome to your LinkedList Program -------");
        System.out.println("This program allows you to create a Linked List and make operations.");

        Scanner scanner = new Scanner(System.in);

        LinkedListNode mainList = new LinkedListNode();

        System.out.println("\nPlease start by creating the Linked List, enter the list's elements. When the list is complete, type \"99\" ");

        boolean listCompleted = true;

        while (listCompleted) {

            try {

                int userInputForTotalList = scanner.nextInt();

                if (userInputForTotalList == 99) {
                    listCompleted = false;
                    System.out.println("\nThank you! The list you have entered is:");
                    mainList.display();
                    break;
                } else {
                    mainList.insertFirst(userInputForTotalList);
                }

            } catch (Exception e) {
                System.out.println("Invalid Entry, please try Again!");
                scanner.next();
            }

        }

        showMenu();

        boolean loopValidation = true;
        while (loopValidation) {
            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Thank you, please enter the number you want to add at the start of the list:");
                        int enterFirstVariable = scanner.nextInt();
                        mainList.insertFirst(enterFirstVariable);
                        System.out.println("\nGreat! the updated list is: ");
                        mainList.display();
                        showMenu();
                        break;
                    case 2:
                        System.out.println("Thank you, please enter the number you want to add at the end of the list:");
                        int enterLastVariable = scanner.nextInt();
                        mainList.insertLast(enterLastVariable);
                        System.out.println("\nGreat! the updated list is: ");
                        showMenu();
                        break;
                    case 3:
                        System.out.println("\nThank you, please enter the number you want to add at the end of the list and its position index:");
                        System.out.println("Enter number:");
                        int enterRandomVariable = scanner.nextInt();
                        System.out.println("Enter index:");
                        int enterRandomPosition = scanner.nextInt();
                        mainList.insertSpecificPosition(enterRandomVariable, enterRandomPosition);
                        System.out.println("\nGreat! the updated list is: ");
                        mainList.display();
                        showMenu();
                        break;
                    case 4:
                        System.out.println("\nThank you, please enter the index value you want to remove:");
                        int enterRandomPositionDeletion = scanner.nextInt();
                        mainList.deleteSpecificPosition(enterRandomPositionDeletion);
                        System.out.println("\nGreat! the updated list is: ");
                        mainList.display();
                        showMenu();
                        break;
                    case 5:
                        System.out.println("This is the updated list: ");
                        mainList.display();
                        break;
                    case 6:
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

    public static void showMenu() {
        System.out.println("\nWhat would you like to do next? Please choose an option:");
        System.out.println("1. I want to add elements at the first position of the list.");
        System.out.println("2. I want to add elements at the last position of the list.");
        System.out.println("3. I want to add elements at a random position of the list.");
        System.out.println("4. I want to remove elements from the list at a specific position.");
        System.out.println("5. I want to display the list.");
        System.out.println("6. I want to exit the program.");

    }
}

