package com.invex.APIEmployee.repository;

import com.invex.APIEmployee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Long> {
}
