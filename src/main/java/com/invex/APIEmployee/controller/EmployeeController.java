package com.invex.APIEmployee.controller;

import com.invex.APIEmployee.entity.EmployeeEntity;
import com.invex.APIEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<>();
        try {
            List<EmployeeEntity> list = employeeService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            EmployeeEntity employee = employeeService.findById(id);
            return new ResponseEntity<Object>(employee, HttpStatus.OK);
        }catch(Exception e){
            Map<String, Object> map = new HashMap<>();
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> createNew(@RequestBody EmployeeEntity newEmployee){
        Map<String, Object> map = new HashMap<>();
        try {
            EmployeeEntity employee = employeeService.save(newEmployee);
            return new ResponseEntity<Object>(employee, HttpStatus.OK);
        }catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/employee")
    public ResponseEntity<Object> update(@RequestBody EmployeeEntity updEmployee){
        Map<String, Object> map = new HashMap<>();
        try {
            EmployeeEntity employee = employeeService.save(updEmployee);
            return new ResponseEntity<Object>(employee, HttpStatus.OK);
        }catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id){
        Map<String, Object> map = new HashMap<>();
        try {
            employeeService.deleteById(id);
            map.put("Employee deleted successfully!", true);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employees/batch")
    public ResponseEntity<List<EmployeeEntity>> createEmployees(@RequestBody List<EmployeeEntity> employees) {
        List<EmployeeEntity> savedEmployees = employeeService.saveAll(employees);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployees);
    }

}
