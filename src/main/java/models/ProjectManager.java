package models;

import annotations.*;

@GeneratedElement(EmployeeTags.PROJECT_MANAGER)
public class ProjectManager implements IEmployee {
    @Name
    private String name;
    @Email
    private String email;
    @Phone
    private String phone;
    @Address
    private String address;
    @Salary
    private double salary;

    public ProjectManager(String name, String email, String phone, String address, double salary) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
    }

    public ProjectManager() {
        this("Name", "email@gmail.com", "0988888888", "St Nicola, 83", 70000);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Project Manager Card");
        sb.append("\nName: ").append(name);
        sb.append("\nEmail: ").append(email);
        sb.append("\nPhone: ").append(phone);
        sb.append("\nAddress: ").append(address);
        sb.append("\nSalary: ").append(salary);
        return sb.toString();
    }

    @Override
    public void doJob() {
        System.out.println("\"I manage, no damage\"");
    }

    @Override
    public void show() {
        System.out.println(this);
    }
}
