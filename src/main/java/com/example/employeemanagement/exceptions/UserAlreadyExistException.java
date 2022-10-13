package com.example.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends Throwable {
    public UserAlreadyExistException(String s, HttpStatus forbidden) {
    }
}
