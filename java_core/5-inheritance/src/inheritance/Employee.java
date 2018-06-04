package inheritance;

import java.time.*;

public class Employee {

    private String name;
    private double salary;
    private LocalDate hriDay;


    public Employee(String name, double salary, int year, int month, int day ) {
        this.name = name;
        this.salary = salary;
        hriDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHriDay() {
        return hriDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
