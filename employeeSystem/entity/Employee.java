package com.task.employeeSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name="employee_name")
    private String employeeName;

    @Column(name="salary")
    private double salary;

    @Column(name = "department")
    private String department;

    @Column(name = "role")
    private String role;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    //@JsonIgnore
    private List<LoginDetails> loginDetails;
    public Employee(int employeeId, String employeeName, double salary, String department, String role) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.department = department;
        this.role = role;
    }

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return employeeId == employee.employeeId && Double.compare(employee.salary, salary) == 0 && Objects.equals(employeeName, employee.employeeName) && Objects.equals(department, employee.department) && Objects.equals(role, employee.role) && Objects.equals(loginDetails, employee.loginDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeName, salary, department, role, loginDetails);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<LoginDetails> getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(List<LoginDetails> loginDetails) {
        this.loginDetails = loginDetails;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", loginDetails=" + loginDetails +
                '}';
    }
}
