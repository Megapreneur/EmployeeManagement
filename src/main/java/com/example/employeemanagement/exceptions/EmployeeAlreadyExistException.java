package com.example.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;

public class EmployeeAlreadyExistException extends EmployeeManagementException {
    public EmployeeAlreadyExistException(String message, HttpStatus status) {
        super(message, status);
    }
}
