package com.example.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;

public class UauthorizedUserException extends Throwable {
    public UauthorizedUserException(String s, HttpStatus notAcceptable) {
    }
}
