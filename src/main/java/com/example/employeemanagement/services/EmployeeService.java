package com.example.employeemanagement.services;

import com.example.employeemanagement.data.models.Employee;
import com.example.employeemanagement.dto.request.AddRequest;
import com.example.employeemanagement.dto.request.UpdateRequest;
import com.example.employeemanagement.dto.response.AddResponse;
import com.example.employeemanagement.dto.response.EmployeeDto;
import com.example.employeemanagement.dto.response.UpdateResponse;
import com.example.employeemanagement.exceptions.EmployeeAlreadyExistException;
import com.example.employeemanagement.exceptions.PasswordMisMatchException;
import com.example.employeemanagement.exceptions.UauthorizedUserException;
import com.example.employeemanagement.exceptions.UserDoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
    AddResponse addEmployee (AddRequest request) throws UserDoesNotExistException, UauthorizedUserException, EmployeeAlreadyExistException, PasswordMisMatchException;
    UpdateResponse updateEmployee(UpdateRequest request) throws UserDoesNotExistException;
    List<EmployeeDto> getAllEmployees();
    Employee findEmployee(String employeeId);
}
