//package com.javalearningtests.pruebasbasicas;/*Acceptance Criteria:
// The system must allow adding new employees with:
//-com.javalearningtests.intermediate.payrolldeduction.Employee ID (unique integer)
//-Full name (string)
//-Department (string)
//
//The system must allow searching for an employee using their ID.
//The system must allow updating an employee’s department.
//The system must allow deleting an employee by ID.
//The system must display all employees sorted by their ID.
//
//Technical Requirements:
//1.Data Structure: Use a HashMap to store employee records (employeeID as the key and an com.javalearningtests.intermediate.payrolldeduction.Employee object as the value).
//
//Implementation Details:
//1.Create an com.javalearningtests.intermediate.payrolldeduction.Employee class with name, and department attributes.
//2.Use Scanner to handle user input in the main program.
//3.Implement methods for adding, searching, updating, and deleting employees.
//4.Implement a method to display all employees sorted by ID.
//
//Error Handling:
//1.Handle cases where an employee ID does not exist.
//2.Prevent duplicate employee IDs from being added.
//
//User Interface:
//1.Provide a menu system for user interaction.
//2.Allow users to perform multiple operations until they choose to exit.*/
//
//import com.javalearningtests.intermediate.payrolldeduction.Employee;
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class EmployeeDataBaseMain {
//
//    static final int finalizeList = 99;
//
//    public static void main(String[] args) {
//
//        System.out.println("-------------Welcome to the com.javalearningtests.intermediate.payrolldeduction.Employee Management System-------------");
//        System.out.println("\nThis is the Main Data Base for com.javalearningtests.intermediate.payrolldeduction.Employee management, where you can find EE Information such as: ID, Name & Department");
//        System.out.println("Please start by entering the EE information.");
//
//        Scanner scanner = new Scanner(System.in);
//
//        HashMap<Integer, Employee> employeeListDataBase = new HashMap<>();
//
//        boolean isListFinished = true;
//        while (isListFinished) {
//            try {
//                System.out.println("\nPlease enter com.javalearningtests.intermediate.payrolldeduction.Employee ID:");
//                int eeId = scanner.nextInt();
//                scanner.nextLine();
//
//                System.out.println("Please enter com.javalearningtests.intermediate.payrolldeduction.Employee's Name:");
//                String name = scanner.nextLine();
//
//                System.out.println("Please enter com.javalearningtests.intermediate.payrolldeduction.Employee's Department:");
//                String department = scanner.nextLine();
//
//                Employee employee = new Employee(name, department);
//
//                employeeListDataBase.put(eeId, employee);
//
//                System.out.println("\nWould you like to add another com.javalearningtests.intermediate.payrolldeduction.Employee? (Type: 1 for Yes , Type: 99 for No)");
//                int continueInsertingEEs = scanner.nextInt();
//
//                if (continueInsertingEEs == finalizeList) {
//                    isListFinished = false;
//                    System.out.println("\nThe com.javalearningtests.intermediate.payrolldeduction.Employee list is as follow: ");
//                    System.out.println(employeeListDataBase);
//                    break;
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid Entry, please try Again!");
//                scanner.next();
//            }
//        }
//        System.out.println("\nWhat action do you want to perform?:");
//        System.out.println("1. I want to add a new com.javalearningtests.intermediate.payrolldeduction.Employee to the database.");
//        System.out.println("2. I want to search for an com.javalearningtests.intermediate.payrolldeduction.Employee in the database.");
//        System.out.println("3. I want to update an com.javalearningtests.intermediate.payrolldeduction.Employee's department in the database.");
//        System.out.println("4. I want to delete an com.javalearningtests.intermediate.payrolldeduction.Employee from the database.");
//        System.out.println("5. I want to Exit.");
//
//        boolean continueLoop = true;
//        while (continueLoop) {
//            try {
//                int menuOption = scanner.nextInt();
//
//                switch (menuOption) {
//
//                    case 1: //Add new com.javalearningtests.intermediate.payrolldeduction.Employee to the DataBase
//                        boolean isListFinished1 = true;
//                        while (isListFinished1) {
//                            try {
//                                System.out.println("\nPlease note, the system won't let you add duplicate Employees.");
//                                System.out.println("Please enter com.javalearningtests.intermediate.payrolldeduction.Employee ID:");
//                                int eeId = scanner.nextInt();
//                                scanner.nextLine();
//
//                                System.out.println("Please enter com.javalearningtests.intermediate.payrolldeduction.Employee's Name:");
//                                String name = scanner.nextLine();
//
//                                System.out.println("Please enter com.javalearningtests.intermediate.payrolldeduction.Employee's Department:");
//                                String department = scanner.nextLine();
//
//                                Employee employee = new Employee(name, department);
//
//                                Employee keyAddedToMap = employeeListDataBase.putIfAbsent(eeId, employee);
//
//                                if (keyAddedToMap == null) {
//                                    System.out.println("The new com.javalearningtests.intermediate.payrolldeduction.Employee was successfully added.");
//                                    System.out.println(employeeListDataBase);
//                                } else {
//                                    System.out.println("ID " + eeId + " already exists in the DataBase");
//                                }
//
//                                System.out.println("\nWould you like to add another com.javalearningtests.intermediate.payrolldeduction.Employee? (Type: 1 for Yes , Type: 99 for No)");
//                                int continueInsertingEEs = scanner.nextInt();
//
//                                if (continueInsertingEEs == finalizeList) {
//                                    isListFinished1 = false;
//                                    System.out.println("\nThe com.javalearningtests.intermediate.payrolldeduction.Employee list is as follow: ");
//                                    System.out.println(employeeListDataBase);
//                                    break;
//                                }
//                            } catch (Exception e) {
//                                System.out.println("Invalid Entry, please try Again!");
//                                scanner.next();
//                            }
//                        }
//                        showMenu();
//                        break;
//
//                    case 2://Search for an com.javalearningtests.intermediate.payrolldeduction.Employee.
//                        System.out.println("Please enter the number you want to search for:");
//
//                        int eeIDtoSearchFor = scanner.nextInt();
//
//                        boolean employeeIsFound = employeeListDataBase.containsKey(eeIDtoSearchFor);
//
//                        if (employeeIsFound) {
//                            System.out.println("com.javalearningtests.intermediate.payrolldeduction.Employee was found!:");
//                            System.out.println(employeeListDataBase.get(eeIDtoSearchFor));
//                        } else {
//                            System.out.println("The employee does not exist in the DataBase.");
//                        }
//                        showMenu();
//                        break;
//                    case 3: //Update an com.javalearningtests.intermediate.payrolldeduction.Employee's department in the database.2
//                        System.out.println("Please enter the com.javalearningtests.intermediate.payrolldeduction.Employee ID of the person you want to update the Department for:");
//
//                        int eeIDtoSearchForDeptUpdate = scanner.nextInt();
//
//                        System.out.println("Please enter the new com.javalearningtests.intermediate.payrolldeduction.Employee's Department:");
//
//                        String eeDepartmentUpdate = scanner.nextLine();
//
//                        Employee searchForEmployee = employeeListDataBase.get(eeIDtoSearchForDeptUpdate);
//
//                        if (searchForEmployee == null) {
//                            System.out.println("The com.javalearningtests.intermediate.payrolldeduction.Employee ID that you have provided, does not exist in the DataBase.");
//                            showMenu();
//                        } else {
//                            employeeListDataBase.get(eeIDtoSearchForDeptUpdate).setDepartment(eeDepartmentUpdate);
//                            System.out.println("Success! This is the new employee information: " + employeeListDataBase.get(eeIDtoSearchForDeptUpdate));
//                            showMenu();
//                        }
//                        break;
//                    case 4: //Delete an com.javalearningtests.intermediate.payrolldeduction.Employee's information from the Data Base
//                        System.out.println("Please enter the com.javalearningtests.intermediate.payrolldeduction.Employee ID of the person you want to delete from the Data Base:");
//
//                        int eeIdToDelete = scanner.nextInt();
//
//                        Employee employeeToRemoveFound = employeeListDataBase.remove(eeIdToDelete);
//
//                        if (employeeToRemoveFound == null) {
//                            System.out.println("The com.javalearningtests.intermediate.payrolldeduction.Employee ID that you have provided, does not exist in the DataBase.");
//                            showMenu();
//
//                        } else {
//                            System.out.println("\nThe employee was successfully removed from the Data Base");
//                            System.out.println("This is the updated list:");
//                            System.out.println(employeeListDataBase);
//                            showMenu();
//                        }
//                        break;
//
//                    case 5: //Exit the program
//                        System.out.println("Thank you for using our program, Have a nice day! ");
//                        return;
//
//                    default:
//                        System.out.println("Please enter a correct option.");
//                }
//            } catch (Exception exception) {
//                System.out.println("Try Again! At the moment our program only supports numbers. No letters or special characters.");
//                scanner.next();
//
//            }
//        }
//    }
//
//    public static void showMenu() {
//        System.out.println("\nWhat would you like to do next? Please choose an option:");
//        System.out.println("1. I want to add a new com.javalearningtests.intermediate.payrolldeduction.Employee to the database.");
//        System.out.println("2. I want to search for an com.javalearningtests.intermediate.payrolldeduction.Employee in the database.");
//        System.out.println("3. I want to update an com.javalearningtests.intermediate.payrolldeduction.Employee's department in the database.");
//        System.out.println("4. I want to delete an com.javalearningtests.intermediate.payrolldeduction.Employee from the database.");
//        System.out.println("5. I want to Exit.");
//
//    }
//}