import java.util.*;
import java.util.stream.*;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + "  " + name + "  " + department + "  " + salary;
    }
}

public class EmployeeDataAnalytics {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(101, "Rahul", "HR", 35000),
                new Employee(102, "Priya", "IT", 60000),
                new Employee(103, "Arun", "Finance", 50000),
                new Employee(104, "Neha", "IT", 75000),
                new Employee(105, "Kiran", "HR", 42000),
                new Employee(106, "Anjali", "Finance", 65000)
        );

        // Filter Employees
        System.out.println("Employees with Salary > 50000");
        employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .forEach(System.out::println);

        // Sort Employees
        System.out.println("\nEmployees Sorted by Salary");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        // Group Employees by Department
        System.out.println("\nEmployees Grouped by Department");
        Map<String, List<Employee>> group =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        group.forEach((dept, list) -> {
            System.out.println(dept);
            list.forEach(System.out::println);
        });

        // Salary Summary
        System.out.println("\nSalary Summary");
        DoubleSummaryStatistics stats =
                employees.stream()
                        .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Count   : " + stats.getCount());
        System.out.println("Total   : " + stats.getSum());
        System.out.println("Average : " + stats.getAverage());
        System.out.println("Maximum : " + stats.getMax());
        System.out.println("Minimum : " + stats.getMin());
    }
}
