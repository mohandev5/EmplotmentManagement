package com.task.employeeSystem.service;

import com.task.employeeSystem.entity.Employee;
import com.task.employeeSystem.entity.LoginDetails;
import com.task.employeeSystem.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepo employeeRepo;

    public Page<Employee> getAllDetails(int pageNumber, int pageSize, String sortAttribute) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortAttribute));
        return employeeRepo.findAll(pageable);
    }

    public List<Employee> getDetailsByName(String employeeName) {
        var nameDetails = employeeRepo.findEmployeeByEmployeeName(employeeName);
        if (nameDetails.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "you entered wrong name");
        } else {
            return nameDetails;
        }
    }


    public List<Duration> getAllWorkingHours(String employeeName) {
        List<Employee> employees = employeeRepo.findEmployeeByEmployeeName(employeeName);
        List<Duration> workingHoursList = new ArrayList<>();
        Duration duration = null;
        Duration totalDuration = Duration.ZERO;

        for (Employee employee : employees) {
            for (LoginDetails loginDetails : employee.getLoginDetails()) {
                LocalTime loginTime = loginDetails.getLogin().toLocalTime();
                LocalTime logoutTime = loginDetails.getLogout().toLocalTime();
                duration = Duration.between(logoutTime, loginTime);
                workingHoursList.add(duration);
             //   totalDuration = totalDuration.plus(duration);
            }
          //  return workingHoursList;

        }
        //return workingHoursList;
        for(int i=0;i<workingHoursList.size();i++){
            totalDuration = totalDuration.plus(duration);
        }
        return Collections.singletonList((totalDuration));
    }
}
