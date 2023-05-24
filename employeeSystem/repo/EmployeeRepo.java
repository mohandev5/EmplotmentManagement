package com.task.employeeSystem.repo;

import com.task.employeeSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    public List<Employee>findEmployeeByEmployeeName(String employeeNmae);

}
