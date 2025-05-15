package com.invex.APIEmployee.service;

import com.invex.APIEmployee.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeEntity> findAll();
    public EmployeeEntity save(EmployeeEntity employeeEntity);
    public EmployeeEntity findById(Long id);
    public void delete(EmployeeEntity employeeEntity);
    public void deleteById(Long id);
    public List<EmployeeEntity> saveAll(List<EmployeeEntity> employeeEntities);
}
