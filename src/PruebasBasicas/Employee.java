

package PruebasBasicas;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return  " Employee Name: " + name  + " , " + "Department: " + department;
    }
}