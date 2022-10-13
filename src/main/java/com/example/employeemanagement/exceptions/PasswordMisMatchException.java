package com.example.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;

public class PasswordMisMatchException extends Throwable {
    public PasswordMisMatchException(String s, HttpStatus notAcceptable) {
    }
}
