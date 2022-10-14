package com.example.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;

public class UserDoesNotExistException extends EmployeeManagementException {
    public UserDoesNotExistException(String message, HttpStatus status) {
        super(message, status);
    }
}
