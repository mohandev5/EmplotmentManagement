package com.task.employeeSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "timetable")
public class LoginDetails {
    @Id
    @GeneratedValue
    @Column(name = "login_id")
    private int loginId;

    @Column(name = "day_number")
    private int dayNumber;

    @Column(name = "login")
    private Time login;

    @Column(name = "logout")
    private Time logout;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id")
    private Employee employee;

    public LoginDetails(int loginId, int dayNumber, Time login, Time logout) {
        this.loginId = loginId;
        this.dayNumber = dayNumber;
        this.login = login;
        this.logout = logout;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Time getLogin() {
        return login;
    }

    public void setLogin(Time login) {
        this.login = login;
    }

    public Time getLogout() {
        return logout;
    }

    public void setLogout(Time logout) {
        this.logout = logout;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LoginDetails() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginDetails that)) return false;
        return getLoginId() == that.getLoginId() && getDayNumber() == that.getDayNumber() && Objects.equals(getLogin(), that.getLogin()) && Objects.equals(getLogout(), that.getLogout()) && Objects.equals(getEmployee(), that.getEmployee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLoginId(), getDayNumber(), getLogin(), getLogout(), getEmployee());
    }

    @Override
    public String toString() {
        return "LoginDetails{" +
                "loginId=" + loginId +
                ", dayNumber=" + dayNumber +
                ", login=" + login +
                ", logout=" + logout +
                ", employee=" + employee +
                '}';
    }
}
