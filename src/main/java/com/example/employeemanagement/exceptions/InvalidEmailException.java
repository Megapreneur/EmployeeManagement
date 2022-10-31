package com.example.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidEmailException extends EmployeeManagementException {
    public InvalidEmailException(String message, HttpStatus status) {
        super(message, status);
    }
}
