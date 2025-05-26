package com.javalearningtests.pruebasbasicas;/*Scenario:
You are working as a software developer for a logistics company that manages package deliveries.
The company wants to optimize package tracking by using a binary tree to store package IDs efficiently.
Each package has a unique tracking number, and they need to be stored in a way that allows fast searching, insertion, and removal.

Your task is to implement a Binary Search Tree (BST) to manage package deliveries.

Test Objectives:
-Implement a Binary Tree structure.
-Support insertion of new package tracking numbers.
-Implement search functionality to quickly find a package.
-Implement deletion of a package from the system.
-Implement tree traversal methods (in-order, pre-order, post-order).

Requirements:
Create a PackageBST class that represents a binary search tree.
Define a PackageNode class to represent each package with attributes:
int trackingNumber (Unique ID for each package)
PackageNode left (Left child)
PackageNode right (Right child)
Implement methods in PackageBST:
void insert(int trackingNumber): Adds a package.
boolean search(int trackingNumber): Checks if a package exists.
void delete(int trackingNumber): Removes a package from the tree.
void inOrderTraversal(): Prints package IDs in ascending order.
void preOrderTraversal(): Prints package IDs in pre-order.
void postOrderTraversal(): Prints package IDs in post-order. */

import java.util.Scanner;

public class BinaryTreesTest {

    public static void main(String[] args) {
        System.out.println("------- Package Management System -------");
        System.out.println("This program allows you to Add Tracking Numbers, Search Tracking Numbers and Delete Tracking Numbers.");

        Scanner scanner = new Scanner(System.in);

        BinaryTreeNode packageDataBase = new BinaryTreeNode();

        System.out.println("\nStart by creating the Initial Package List. Enter the list's elements. When the list is complete, type \"99\" ");

        boolean listCompleted = true;

        while (listCompleted) {

            try {

                int userInputForInitialList = scanner.nextInt();

                if (userInputForInitialList == 99) {
                    listCompleted = false;
                    System.out.println("\nThank you! The list you have entered is: (Note: This list is in ascending order)");
                    packageDataBase.inOrder();
                    break;
                } else {
                    packageDataBase.insert(userInputForInitialList);
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
                        System.out.println("Thank you, please enter the package's tracking number to the Data Base:");
                        int enterAdditionalPackage = scanner.nextInt();
                        packageDataBase.insert(enterAdditionalPackage);
                        System.out.println("\nGreat! the updated list is: ");
                        packageDataBase.postOrder();
                        showMenu();
                        break;
                    case 2:
                        System.out.println("Thank you, please enter the Tracking Number you want to search for:");
                        int trackingNumberToSearch = scanner.nextInt();
                        boolean result = packageDataBase.iterativeSearch(packageDataBase.root, trackingNumberToSearch);
                        if (result){
                            System.out.println("This package exists in the Data Base");
                        } else {
                            System.out.println("This package does not exist in the Data Base");
                        }
                        break;
                    case 3:
                        System.out.println("\nThank you, please enter the package you want to delete using Tracking Number:");
                        int deleteTrackingNumber = scanner.nextInt();
                        packageDataBase.root= packageDataBase.delete(packageDataBase.root, deleteTrackingNumber);
                        System.out.println("\nGreat! the updated list is: ");
                        packageDataBase.inOrder();
                        showMenu();
                        break;
                    case 4:
                        System.out.println("\nThank you, this is the Data Base content displayed in Pre-Order form:");
                        packageDataBase.preOrder();
                        showMenu();
                        break;
                    case 5:
                        System.out.println("\nThank you, this is the Data Base content displayed in In-Order form:");
                        packageDataBase.inOrder();
                        showMenu();
                        break;
                    case 6:
                        System.out.println("\nThank you, this is the Data Base content displayed in Post-Order form:");
                        packageDataBase.postOrder();
                        showMenu();
                        break;
                    case 7:
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
        System.out.println("1. I want to add packages to the Data Base");
        System.out.println("2. I want to search for package using a Tracking Number.");
        System.out.println("3. I want to delete a package from the Data Base using a Tracking Number.");
        System.out.println("4. I want to display the packages with pre-order form");
        System.out.println("5. I want to display the packages with in-order form");
        System.out.println("6. I want to display the packages with post-order form");
        System.out.println("7. I want to exit the program.");
    }

}
