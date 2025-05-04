package IntermediateTests;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

import static IntermediateTests.EmployeePayrollDeductionDataBase.NewEmployee.POSITIVE_START_VALUE;
import static java.lang.Math.round;

@Getter
@Setter

public class EmployeePayrollDeductionDataBase {

    public boolean additionalEmployeeValidationLoop(Scanner scanner, ArrayList<NewEmployee> newEmployee) {

        boolean continueLoop = true;

        boolean isValidInput = false;
        while (!isValidInput) {

            System.out.println("\nWould you like to add another Employee? (Yes / No)");
            String continueInsertingEEs = scanner.nextLine().trim();

            if (continueInsertingEEs.equalsIgnoreCase("no")) {
                continueLoop = false;
                isValidInput = true;
                System.out.println("\nThank you! The list you have entered is:");
                for (NewEmployee tempEmployee : newEmployee) {
                    tempEmployee.printSummary();
                    System.out.println("---------------------------");
                }
                return false;
            } else if (continueInsertingEEs.isEmpty()) {
                System.out.println("Please confirm if you'd like to enter more Employees, it cannot be blank! ");

            } else if (continueInsertingEEs.equalsIgnoreCase("yes")) {
                return true;

            } else {
                System.out.println("Invalid Entry, please enter Yes or No.");
            }
        }
        return false;
    }

    class NewEmployee {


        private String name;
        private String department;
        private double grossSalary;
        private double deductionAmount;
        private double netSalary;
        private Scanner scanner;


        public NewEmployee(String name, String department, double grossSalary) {
            this.name = name;
            this.department = department;
            this.grossSalary = grossSalary;

        }

        final static int LOWER_LIMIT_SALARY_VALUE = 2000;
        final static int HIGHER_LIMIT_SALARY_VALUE = 5000;
        final static float LOWER_LIMIT_DEDUCTION_PERCENTAGE = 0.10f;
        final static float HIGHER_LIMIT_DEDUCTION_PERCENTAGE = 0.20f;
        final static int POSITIVE_START_VALUE = 0;

        public void calculateDeductions() {
            if (grossSalary > LOWER_LIMIT_SALARY_VALUE && grossSalary < HIGHER_LIMIT_SALARY_VALUE) {
                deductionAmount = grossSalary * LOWER_LIMIT_DEDUCTION_PERCENTAGE;
                netSalary = grossSalary - deductionAmount;

                BigDecimal netSalaryWith2Decimals = new BigDecimal(netSalary);
                netSalaryWith2Decimals = netSalaryWith2Decimals.setScale(2, RoundingMode.HALF_UP);
                netSalary = netSalaryWith2Decimals.doubleValue();

                BigDecimal deductionAmountWith2Decimals = new BigDecimal(deductionAmount);
                deductionAmountWith2Decimals = deductionAmountWith2Decimals.setScale(2, RoundingMode.HALF_UP);
                deductionAmount = deductionAmountWith2Decimals.doubleValue();

            } else if (grossSalary > HIGHER_LIMIT_SALARY_VALUE) {
                deductionAmount = grossSalary * HIGHER_LIMIT_DEDUCTION_PERCENTAGE;
                netSalary = grossSalary - deductionAmount;

                BigDecimal netSalaryWith2Decimals = new BigDecimal(netSalary);
                netSalaryWith2Decimals = netSalaryWith2Decimals.setScale(2, RoundingMode.HALF_UP);
                netSalary = netSalaryWith2Decimals.doubleValue();

                BigDecimal deductionAmountWith2Decimals = new BigDecimal(deductionAmount);
                deductionAmountWith2Decimals = deductionAmountWith2Decimals.setScale(2, RoundingMode.HALF_UP);
                deductionAmount = deductionAmountWith2Decimals.doubleValue();

            } else {
                netSalary = grossSalary;
            }
        }


        public void printSummary() {
            System.out.println("Employee Name: " + name);
            System.out.println("Department: " + department);
            System.out.println("Gross Salary: " + "$" + grossSalary);
            System.out.println("Deduction Amount: " + "$" + deductionAmount);
            System.out.println("Net Salary: " + "$" + netSalary);
        }
    }


    public void enteringMultipleEmployeeData(Scanner scanner, ArrayList<NewEmployee> newEmployee) {

        String eeName;
        boolean isValidNameEntered = false;

        do {
            System.out.println("\nPlease enter the Employee's Name:");
            eeName = scanner.nextLine().trim();

            if (eeName.isEmpty()) {
                System.out.print("Please enter an Employee's name, it cannot be blank! ");
            } else if (eeName.matches(".*\\d.*")) {
                System.out.println("Invalid input. The name cannot contain numbers!");
            } else {
                isValidNameEntered = true;
            }

        } while (!isValidNameEntered);

        String eeDepartment;
        boolean isValidDepartmentEntered = false;

        do {
            System.out.println("\nPlease enter the Employee's Department:");
            eeDepartment = scanner.nextLine().trim();

            if (eeDepartment.isEmpty()) {
                System.out.print("Please enter an Department's name, it cannot be blank! ");
            } else if (eeDepartment.matches(".*\\d.*")) {
                System.out.println("Invalid input. The department cannot contain numbers!");
            } else {
                isValidDepartmentEntered = true;
            }

        } while (!isValidDepartmentEntered);

        double eeSalary = 0;
        boolean isNumberEntered = false;

        while (!isNumberEntered) {
            System.out.println("\nPlease enter the Employee's Salary:");
            String tempInput = scanner.nextLine();

            if (tempInput.trim().isEmpty()) {
                System.out.print("Please enter an Employee's Salary, it cannot be blank! ");
            } else {
                try {
                    eeSalary = Double.parseDouble(tempInput);
                    if (eeSalary < NewEmployee.POSITIVE_START_VALUE) {
                        System.out.println("Invalid input. Salary must be a positive number.");
                        continue;
                    }
                    isNumberEntered = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Salary must be a dollar amount!");
                }
            }
        }

        NewEmployee newEmployeeAdditions = new NewEmployee(eeName, eeDepartment, eeSalary);
        newEmployeeAdditions.calculateDeductions();

        newEmployee.add(newEmployeeAdditions);
    }
}

