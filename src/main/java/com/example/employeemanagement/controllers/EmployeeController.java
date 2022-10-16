package com.example.employeemanagement.controllers;

import com.example.employeemanagement.data.models.Employee;
import com.example.employeemanagement.dto.request.AddRequest;
import com.example.employeemanagement.dto.request.FindRequest;
import com.example.employeemanagement.dto.response.AddResponse;
import com.example.employeemanagement.dto.response.EmployeeDto;
import com.example.employeemanagement.exceptions.*;
import com.example.employeemanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/employee/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("addEmployee/")
    public AddResponse AddEmployee(@RequestBody AddRequest request) throws UserDoesNotExistException,
            UauthorizedUserException, PasswordMisMatchException, EmployeeAlreadyExistException {
        return employeeService.addEmployee(request);
    }
    @GetMapping("getAllEmployee/")
    public List<EmployeeDto> getAllEmployee(){

        return  employeeService.getAllEmployees();
    }
    @GetMapping("findAnEmployee/")
    public Employee getEmployee(@RequestBody String employeeId) throws EmployeeManagementException {
        return employeeService.findEmployee(employeeId);
    }

}
