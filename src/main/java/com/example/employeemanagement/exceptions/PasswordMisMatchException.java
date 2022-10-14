package com.example.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;

public class PasswordMisMatchException extends EmployeeManagementException {
    public PasswordMisMatchException(String message, HttpStatus status) {
        super(message, status);
    }
}
