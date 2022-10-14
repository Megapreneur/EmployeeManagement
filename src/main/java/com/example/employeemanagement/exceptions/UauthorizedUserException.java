package com.example.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;

public class UauthorizedUserException extends EmployeeManagementException {
    public UauthorizedUserException(String message, HttpStatus status) {
        super(message, status);
    }
}
