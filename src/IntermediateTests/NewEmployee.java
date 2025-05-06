package IntermediateTests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

@Getter
@Setter

public class NewEmployee {

    private String name;
    protected String department;
    private Scanner scanner;
    private double grossSalary;

    public NewEmployee(String name, String department, double grossSalary) {
        this.name = name;
        this.department = department;
        this.grossSalary = grossSalary;
    }

}
