Calculator Program

Test 2: Advanced Calculator with File Logging
This project implements a comprehensive calculator application that performs basic arithmetic operations 
(addition, subtraction, multiplication, division), advanced mathematical functions (power and square root), 
and maintains a persistent log of all calculations. 
The program demonstrates robust input validation, error handling, and file I/O operations. 
It uses BigDecimal for precise mathematical calculations, helper methods for code reusability, 
and a clean separation of concerns with dedicated classes for calculations and file management. 
This exercise reinforces object-oriented design principles, input validation techniques, and professional code structure 
at an intermediate level.

Main method in: CalculatorProgramMain

Documentation
Create a calculator program that allows users to perform various mathematical operations 
with robust error handling and automatic logging of results. The goal is to simulate a professional-grade calculator application 
with proper input validation, precise calculations, and persistent data storage.

Instructions
Display a menu with mathematical operation options (addition, subtraction, multiplication, division, power, square root, exit)
Validate all user inputs with appropriate error messages for invalid data
Handle special cases:

Division by zero prevention
Negative numbers for square root operations
Integer validation for power operations


Perform calculations using BigDecimal for precision in financial and scientific computations
Log all calculation results to a text file (calculation_log.txt) for future reference
Implement a clean menu-driven interface with continuous operation until user chooses to exit
Use helper methods to eliminate code duplication and improve maintainability

Solution
The program uses:

Scanner for user input with comprehensive validation
BigDecimal with setScale and RoundingMode to handle precise mathematical calculations
Helper methods for specialized input validation:

getValidNumberInput() - Basic number validation with error handling
getValidDivisorInput() - Division-specific validation preventing zero division
validNumberForPowerInput() - Integer validation for power operations
getPositiveNumberSqrt() - Positive number validation for square root


calculateSquareRoot() method using Newton's algorithm for BigDecimal precision
CalculatorProgramFileManager class for file operations with proper exception handling
Menu-driven interface with switch-case structure and continuous operation loop
Clear separation of concerns with dedicated methods for each mathematical operation

Project Structure
src/main/java/com/javalearningtests/intermediate/calculatorprogram/
├── CalculatorProgramMain.java          # Main class with menu and program flow
├── CalculatorProgramMethods.java       # Mathematical operations and helper methods
└── CalculatorProgramFileManager.java   # File logging functionality

Features
Basic Arithmetic: Addition, subtraction, multiplication, division
Advanced Operations: Power calculations, square root using Newton's method
Input Validation: Comprehensive error handling for all input types
File Logging: Automatic logging of all calculations to text file
Precision Mathematics: BigDecimal implementation for accurate calculations
Professional Code Structure: Helper methods, single responsibility principle
User-Friendly Interface: Clear prompts and error messages

Objective
The objective of this project is to serve as a valuable resource for continuous learning and 
development of intermediate programming skills. Through building this calculator, 
you will master input validation techniques, mathematical precision handling, file I/O operations, and professional code 
organization patterns. As you complete this project, you will be better prepared to face more complex challenges 
and advance in your career as a developer.

Good luck and happy coding!