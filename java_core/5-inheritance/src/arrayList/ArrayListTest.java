package arrayList;


import java.util.ArrayList;

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Employee> arrayList = new ArrayList<>();

        arrayList.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        arrayList.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        arrayList.add(new Employee("Tony Tester", 40000, 1990, 3, 15));



        for (Employee e : arrayList)
            e.raiseSalary(5);

        for (Employee e : arrayList)
            System.out.println(e.toString());
    }
}
