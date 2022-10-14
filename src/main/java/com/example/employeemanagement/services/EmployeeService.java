package com.example.employeemanagement.services;

import com.example.employeemanagement.data.models.Employee;
import com.example.employeemanagement.dto.request.AddRequest;
import com.example.employeemanagement.dto.request.UpdateRequest;
import com.example.employeemanagement.dto.response.AddResponse;
import com.example.employeemanagement.dto.response.UpdateResponse;
import com.example.employeemanagement.exceptions.EmployeeAlreadyExistException;
import com.example.employeemanagement.exceptions.PasswordMisMatchException;
import com.example.employeemanagement.exceptions.UauthorizedUserException;
import com.example.employeemanagement.exceptions.UserDoesNotExistException;

import java.util.List;

public interface EmployeeService {
    AddResponse addEmployee (AddRequest request) throws UserDoesNotExistException, UauthorizedUserException, EmployeeAlreadyExistException, PasswordMisMatchException;
    UpdateResponse updateEmployee(UpdateRequest request) throws UserDoesNotExistException;
    List<Employee> getAllEmployees();
}
