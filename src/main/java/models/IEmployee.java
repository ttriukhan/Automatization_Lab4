package models;

import annotations.*;

@GeneratedFactory
public interface IEmployee {

    @Name
    String getName();
    void setName(String name);

    @Email
    String getEmail();
    void setEmail(String email);

    @Phone
    String getPhone();
    void setPhone(String phone);

    @Address
    String getAddress();
    void setAddress(String address);

    @Salary
    double getSalary();
    void setSalary(double salary);

    void doJob();

    void show();
}
