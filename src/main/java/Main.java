import models.IEmployee;
import models.EmployeeFactory;
import models.EmployeeTags;
import utils.Validator;

public class Main {
    public static void main(String[] args) {

        IEmployee[] employees = {
                EmployeeFactory.createEmployee(EmployeeTags.CEO),
                EmployeeFactory.createEmployee(EmployeeTags.PROJECT_MANAGER),
                EmployeeFactory.createEmployee(EmployeeTags.DEVELOPER),
                EmployeeFactory.createEmployee(EmployeeTags.TESTER),
                EmployeeFactory.createEmployee(EmployeeTags.OTHER)
        };

        System.out.println("\nDefault good employees:\n");
        for (IEmployee employee: employees) {
            System.out.println(employee);
            try {
                Validator.validate(employee);
                System.out.println("IEmployee validated successfully:");
                employee.doJob();
                System.out.println("----------------------------------\n\n");
            } catch (Exception e) {
                System.out.println("Validation error for employee " + employee.getName() + ": " + e.getMessage());
                System.out.println("----------------------------------\n\n");
            }
        }

        employees[0].setName("WRONG NAME ***");
        employees[1].setEmail("WRONG EMAIL");
        employees[2].setPhone("WRONG PHONE");
        employees[3].setAddress("WRONG ADDRESS &&&");
        employees[4].setSalary(-500);

        System.out.println("\nBad employees: \n");
        for (IEmployee employee: employees) {
            System.out.println(employee);
            try {
                Validator.validate(employee);
                System.out.println("Employee validated successfully:");
                employee.doJob();
                System.out.println("----------------------------------\n\n");
            } catch (Exception e) {
                System.out.println("Validation error for employee " + employee.getName() + ": " + e.getMessage());
                System.out.println("----------------------------------\n\n");
            }
        }

    }
}
