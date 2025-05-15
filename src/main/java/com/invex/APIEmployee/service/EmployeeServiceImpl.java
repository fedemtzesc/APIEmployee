package com.invex.APIEmployee.service;

import com.invex.APIEmployee.entity.EmployeeEntity;
import com.invex.APIEmployee.repository.EmployeeDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<EmployeeEntity> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return employeeDAO.save(employeeEntity);
    }

    @Override
    @Transactional
    public EmployeeEntity findById(Long id) {
        return employeeDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void delete(EmployeeEntity employeeEntity) {
        employeeDAO.delete(employeeEntity);
    }

    @Override
    public void deleteById(Long id) {
        employeeDAO.deleteById(id);
    }

    @Override
    public List<EmployeeEntity> saveAll(List<EmployeeEntity> employeeEntities) {
        if (employeeEntities == null || employeeEntities.isEmpty()) return Collections.emptyList();
        return employeeDAO.saveAll(employeeEntities);
    }
}
