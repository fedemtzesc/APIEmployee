package com.invex.APIEmployee.service;

import com.invex.APIEmployee.controller.dto.EmployeePatchDTO;
import com.invex.APIEmployee.entity.EmployeeEntity;
import com.invex.APIEmployee.repository.EmployeeDAO;
import jakarta.transaction.Transactional;
import org.springdoc.api.OpenApiResourceNotFoundException;
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

    @Override
    public List<EmployeeEntity> saveAllFunctional(List<EmployeeEntity> employeeEntities) {
        if (employeeEntities == null || employeeEntities.isEmpty()) return Collections.emptyList();
        return employeeEntities.stream()
                .map(e -> employeeDAO.save(e))
                .toList();
    }

    @Override
    @Transactional
    public EmployeeEntity partialUpdate(Long id, EmployeePatchDTO patchDTO) {
        EmployeeEntity employee = employeeDAO.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Empleado no encontrado con ID: " + id));

        if (patchDTO.getFirstName() != null) {
            employee.setFirstName(patchDTO.getFirstName());
        }
        if (patchDTO.getMiddleName() != null) {
            employee.setMiddleName(patchDTO.getMiddleName());
        }
        if (patchDTO.getPaternalSurname() != null) {
            employee.setPaternalSurname(patchDTO.getPaternalSurname());
        }
        if (patchDTO.getMaternalSurname() != null) {
            employee.setMaternalSurname(patchDTO.getMaternalSurname());
        }
        if (patchDTO.getAge() != 0) {
            employee.setAge(patchDTO.getAge());
        }

        if (patchDTO.getSex() != null) {
            employee.setSex(patchDTO.getSex());
        }
        if (patchDTO.getBirthDate() != null) {
            employee.setBirthDate(patchDTO.getBirthDate());
        }
        if (patchDTO.getJobPosition() != null) {
            employee.setJobPosition(patchDTO.getJobPosition());
        }
        return employeeDAO.save(employee);
    }
}
