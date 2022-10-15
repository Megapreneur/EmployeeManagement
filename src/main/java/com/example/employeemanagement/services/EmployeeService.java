package com.example.employeemanagement.services;

import com.example.employeemanagement.data.models.Employee;
import com.example.employeemanagement.dto.request.AddRequest;
import com.example.employeemanagement.dto.request.UpdateRequest;
import com.example.employeemanagement.dto.response.AddResponse;
import com.example.employeemanagement.dto.response.EmployeeDto;
import com.example.employeemanagement.dto.response.UpdateResponse;
import com.example.employeemanagement.exceptions.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    AddResponse addEmployee (AddRequest request) throws UserDoesNotExistException, UauthorizedUserException, EmployeeAlreadyExistException, PasswordMisMatchException;
    UpdateResponse updateEmployee(UpdateRequest request) throws UserDoesNotExistException;
    List<EmployeeDto> getAllEmployees();
    Optional<Employee> findEmployee(String employeeId) throws EmployeeManagementException;
}
