package com.example.employeemanagement.services;

import com.example.employeemanagement.dto.request.LoginRequest;
import com.example.employeemanagement.dto.response.LoginResponse;
import com.example.employeemanagement.dto.request.RegisterRequest;
import com.example.employeemanagement.dto.response.RegisterResponse;
import com.example.employeemanagement.exceptions.PasswordMisMatchException;
import com.example.employeemanagement.exceptions.UserAlreadyExistException;
import com.example.employeemanagement.exceptions.UserDoesNotExistException;

public interface AdminService {
    RegisterResponse register (RegisterRequest request) throws PasswordMisMatchException, UserAlreadyExistException;
    LoginResponse login (LoginRequest request) throws UserDoesNotExistException;
}
