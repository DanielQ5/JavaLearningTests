/*As an HR officer,
I want a program where I can input an employee's salary and see deductions applied based on salary ranges,
So that I can quickly calculate their net take-home pay.

Acceptance Criteria
The program asks the user for the number of employees to process.

For each employee:
Prompt for their name and gross salary.
Based on the gross salary, apply deductions:
If salary < 2000 → no deductions.
If salary is between 2000 and 5000 → apply 10% deduction.
If salary > 5000 → apply 20% deduction.

The program should print the employee’s name, original salary, deduction amount, and net salary.

The user should be asked if they want to process another batch (loop).

Input should be validated:
No negative salaries.
No non-numeric inputs.

Use at least one if-else structure and one while or do-while loop.
Requirements (Dev Notes)
Follow Java best practices.
Make the output clear and formatted nicely.

Use Scanner for input.
Bonus: Use continue or break smartly for flow control.*/

package IntermediateTests;

import java.util.ArrayList;
import java.util.Scanner;

public class PayrollDeductionCalculator {


    public static void main(String[] args) {
        System.out.println("-------Employee Information Data Base-------");
        System.out.println("\nThis program allows you to log employee information in the DataBase");
        System.out.println("Start by entering Employee information.");

        Scanner scanner = new Scanner(System.in);
        ArrayList<NewEmployee> newEmployeeInitialInput = new ArrayList<>();
        EmployeePayrollDeductionDataBase employeePayrollDeductionDataBase = new EmployeePayrollDeductionDataBase();

        boolean continueLoop = true;
        while (continueLoop) {

            employeePayrollDeductionDataBase.enteringMultipleEmployeeData(scanner, newEmployeeInitialInput);
            continueLoop = employeePayrollDeductionDataBase.additionalEmployeeValidationLoop(scanner, newEmployeeInitialInput);

        }

    }
}
