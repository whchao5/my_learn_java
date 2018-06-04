package inheritance;

public class ManagerTest {

    public static void main(String[] args) {
        Manager manager = new Manager("carl Cracker", 80000, 1987, 12, 15);

        manager.setBonus(5000);

        Employee[] staff = new Employee[3];


        staff[0] = manager;         // 编译器看成 Employee
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);


        staff[0].raiseSalary(5);

        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
    }
}
