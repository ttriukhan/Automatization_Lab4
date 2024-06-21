package models;

import annotations.*;

@GenerateClass(className = "EmployeeWithoutAnnotations", fields = {"name", "position", "email", "phone", "address", "salary"})
public class Employee {

    @Name
    private String name;
    @annotations.Position
    private String position;
    @Email
    private String email;
    @Phone
    private String phone;
    @Address
    private String address;
    @Salary
    private double salary;

    public Employee(String name, String position, String email, String phone, String address, double salary) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee Card");
        sb.append("\nName: ").append(name);
        sb.append("\nPosition: ").append(position.toString());
        sb.append("\nEmail: ").append(email);
        sb.append("\nPhone: ").append(phone);
        sb.append("\nAddress: ").append(address);
        sb.append("\nSalary: ").append(salary);
        return sb.toString();
    }
}
