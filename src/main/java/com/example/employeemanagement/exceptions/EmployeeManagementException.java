package com.example.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;

public class EmployeeManagementException extends Exception{
    private HttpStatus status;

    public EmployeeManagementException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}
