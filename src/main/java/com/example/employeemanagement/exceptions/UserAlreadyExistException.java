package com.example.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends EmployeeManagementException {
    public UserAlreadyExistException(String message, HttpStatus status) {
        super(message, status);
    }
}
