package com.invex.APIEmployee.controller;

import com.invex.APIEmployee.controller.dto.EmployeePatchDTO;
import com.invex.APIEmployee.entity.EmployeeEntity;
import com.invex.APIEmployee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "1.0 Retrieves the list of all registered Employees",
            description = "If no employees are registered into DB, an empty list is returned. Using the GET method")
    @GetMapping("/employee")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<>();
        try {
            List<EmployeeEntity> list = employeeService.findAll();
            map.put("status", "OK");
            map.put("message", "Successfull Request");
            map.put("Employees", list);
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }catch(Exception e){
            map.put("status", "FAIL");
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "2.0 Query an Employee by their ID in the endpoint's path",
            description = "If employee not found into DB, a message and status will be returned. Using the GET method")
    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        Map<String, Object> map = new HashMap<>();
        try {
            EmployeeEntity employee = employeeService.findById(id);
            map.put("status", "OK");
            map.put("message", "Successfull Request");
            map.put("Recovered Employee", employee);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }catch(Exception e){
            map.put("status", "FAIL");
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "3.0 Create a new Employee",
            description = "Create a new employee using the POST method")
    @PostMapping("/employee")
    public ResponseEntity<Object> createNew(@RequestBody EmployeeEntity newEmployee){
        Map<String, Object> map = new HashMap<>();
        try {
            EmployeeEntity employee = employeeService.save(newEmployee);
            map.put("status", "OK");
            map.put("message", "Employee created successfuly");
            map.put("new-employee", employee);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }catch(Exception e){
            map.put("status", "FAIL");
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "4.0 Update an Employee",
            description = "Update an employee specifing it's Id, and all the rest of fields. using the PUT method")
    @PutMapping("/employee")
    public ResponseEntity<Object> update(@RequestBody EmployeeEntity updEmployee){
        Map<String, Object> map = new HashMap<>();
        try {
            EmployeeEntity employee = employeeService.save(updEmployee);
            map.put("status", "OK");
            map.put("message", "Employee updated successfuly");
            map.put("updated-employee", employee);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }catch(Exception e){
            map.put("status", "FAIL");
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "5.0 Delete an Employee",
            description = "Delete an employee specifing it's Id in the end-point's path. Using the DELETE method")
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<>();
        try {
            employeeService.deleteById(id);
            map.put("status", "OK");
            map.put("Employee deleted successfully!", true);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }catch(Exception e){
            map.put("status", "FAIL");
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "6.0 Create one or many Employees",
            description = "Save one or a Employees list into DB. Using the POST method")
    @PostMapping("/employees/batch")
    public ResponseEntity<Object> createEmployeeBatch(@RequestBody List<EmployeeEntity> employees) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<EmployeeEntity> savedEmployees = employeeService.saveAll(employees);
            map.put("Employee list saved successfully!", true);
            map.put("status", "OK");
            map.put("saved-employees", savedEmployees);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }catch(Exception e){
            map.put("status", "FAIL");
            map.put("message", "Employee List cannot be saved");
            map.put("error:", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "7.0 Create one or many Employees",
            description = "Save one or a Employees list into DB. Using the POST method")
    @PostMapping("/employees/batch/functional")
    public ResponseEntity<Object> createEmployeeBatchFunctional(@RequestBody List<EmployeeEntity> employees) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<EmployeeEntity> savedEmployees = employeeService.saveAllFunctional(employees);
            map.put("Employee list saved successfully!", true);
            map.put("status", "OK");
            map.put("saved-employees", savedEmployees);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }catch(Exception e){
            map.put("status", "FAIL");
            map.put("message", "Employee List cannot be saved");
            map.put("error:", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "8.0 Partial Update an Employee",
            description = "Update an employee specifing it's Id, and only field that you need to update. using the PATCH method")
    @PatchMapping("/employee/{id}")
    public ResponseEntity<Object> partialUpdateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeePatchDTO patchDTO){

        Map<String, Object> map = new HashMap<>();
        try {
            EmployeeEntity employee = employeeService.partialUpdate(id, patchDTO);
            map.put("status", "OK");
            map.put("message", "Employee partialy updated successfuly");
            map.put("partialy-updated-employee", employee);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }catch(Exception e){
            map.put("status", "FAIL");
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
