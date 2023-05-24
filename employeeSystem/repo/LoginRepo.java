package com.task.employeeSystem.repo;

import com.task.employeeSystem.entity.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepo extends JpaRepository<LoginDetails,Integer> {

    List<LoginDetails> findLoginDetaisByLoginId(int loginId);
}
