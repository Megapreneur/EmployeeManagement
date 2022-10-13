package com.example.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;

public class UserDoesNotExistException extends Throwable {
    public UserDoesNotExistException(String invalid_login_details, HttpStatus notFound) {
    }
}
