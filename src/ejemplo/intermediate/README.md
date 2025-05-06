##Intermediate Tests

This folder is dedicated to storing all intermediate-level projects. Here you will find a collection of tests. 
Each project focuses on different aspects and challenges, providing a solid foundation for advancing to more advanced levels.

## Content

**Intermediate-level projects**: 

**Test 1: Employee Management System **  
This project simulates an employee registration and payroll deduction system.
It allows the user to enter multiple employees' data (name, department, and salary), validates each input, calculates deductions based on salary thresholds, and displays a summary of each employee.
The system uses `ArrayList` to store dynamic data, nested loops for flow control, and `BigDecimal` for accurate financial calculations.
This exercise helps reinforce input validation, data modeling, and program structure at an intermediate level.

**Documentation**:
Create a program that allows users to register multiple employees, validate their inputs, and calculate salary deductions based on predefined income ranges. The goal is to simulate a real-world payroll processing system and apply proper structure, error handling, and precision in financial calculations.

**Instructions:**  
-Prompt the user to enter employee information (name, department, gross salary).
-Validate that names are not empty, departments are from a predefined list, and salaries are numeric and above a minimum threshold.
-Apply deduction rules:
  - If salary is below the lower limit, no deductions.
  - If salary is between the lower and upper limits, apply a 10% deduction.
  - If salary is above the upper limit, apply a 15% deduction.
-Store employee data in a dynamic collection.
-After all entries, print a detailed summary showing all employee information and final net salaries.
-Main method in Payroll Deduction Calculator


**Solution:**  
The program uses:
-`Scanner` for user input.
-`ArrayList` to manage a dynamic number of employees.
-`BigDecimal` with `setScale` and `RoundingMode` to handle monetary values accurately.
-Input validation with loops and conditional structures to ensure data integrity.
-Clear method separation for calculation and output (e.g., `calculateDeductions()`, `printSummary()`).
 
## Objective
The objective of this folder is to serve as a valuable resource for continuous learning and development of intermediate programming skills. As you complete these projects, you will be better prepared to face more complex challenges and advance in your career as a developer.

Good luck and happy coding!
