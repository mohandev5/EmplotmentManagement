package com.task.employeeSystem.service;

import com.task.employeeSystem.entity.LoginDetails;
import com.task.employeeSystem.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginDetailsService {
    @Autowired
    private LoginRepo loginRepo;


}
