import models.Employee;
import utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee[] employeesCandidates = {
                new Employee("John Doe", "Developer", "john.doe@example.com", "+0988888888", "Maven, 25A", 5000.0),
                new Employee("Jane Smith", "Student", "jane.smith@example.com", "+952567854", "Gradle, 90, A4", 7000.0),
                new Employee("Mike Johnson", "CEO", "mike.johnsonexample.com", "+90909090", "Intellij, 54", 10000.0),
                new Employee("Alice Brown", "Intern", "alice.brown@example.com", "+f9999999", "Feta, 38B", 2000.0)
        } ;

        System.out.println("Employee Candidates:");
        for (Employee employee: employeesCandidates) {
            System.out.println("\n"+employee);
        }

        List<Employee> goodEmployees = new ArrayList<>();

        System.out.println("\n\n");
        for (Employee employee: employeesCandidates) {
            if(validateEmployee(employee))
                goodEmployees.add(employee);
        }

        System.out.println("\n\n");
        System.out.println("Good Employees:");
        for(Employee employee: goodEmployees) {
            System.out.println("\n"+employee);
        }

    }

    private static boolean validateEmployee(Employee employee) {
        try {
            Validator.validate(employee);
            System.out.println("Employee validated successfully:");
            System.out.println(employee);
            System.out.println("----------------------------------");
            return true;
        } catch (Exception e) {
            System.out.println("Validation error for employee " + employee.getName() + ": " + e.getMessage());
            System.out.println("----------------------------------");
            return false;
        }
    }
}
