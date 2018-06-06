package arrayList;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

    private String name;
    private double salary;
    private LocalDate hriDay;


    public Employee(String name, double salary, int year, int month, int day) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(hriDay, employee.hriDay);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, salary, hriDay);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hriDay=" + hriDay +
                '}';
    }
}
