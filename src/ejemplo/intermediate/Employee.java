package ejemplo.intermediate;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter

public class Employee {

    private String name;
    protected String department;
    private Scanner scanner;
    private double grossSalary;

    public Employee(String name, String department, double grossSalary) {
        this.name = name;
        this.department = department;
        this.grossSalary = grossSalary;
    }

}
