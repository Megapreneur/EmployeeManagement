package com.example.employeemanagement.controllers;

import com.example.employeemanagement.data.models.Employee;
import com.example.employeemanagement.dto.request.AddRequest;
import com.example.employeemanagement.dto.response.AddResponse;
import com.example.employeemanagement.dto.response.EmployeeDto;
import com.example.employeemanagement.exceptions.EmployeeAlreadyExistException;
import com.example.employeemanagement.exceptions.PasswordMisMatchException;
import com.example.employeemanagement.exceptions.UauthorizedUserException;
import com.example.employeemanagement.exceptions.UserDoesNotExistException;
import com.example.employeemanagement.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
}
