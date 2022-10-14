package com.example.employeemanagement.controllers;

import com.example.employeemanagement.dto.request.LoginRequest;
import com.example.employeemanagement.dto.request.RegisterRequest;
import com.example.employeemanagement.dto.response.LoginResponse;
import com.example.employeemanagement.dto.response.RegisterResponse;
import com.example.employeemanagement.exceptions.PasswordMisMatchException;
import com.example.employeemanagement.exceptions.UserAlreadyExistException;
import com.example.employeemanagement.exceptions.UserDoesNotExistException;
import com.example.employeemanagement.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin/")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("register/")
    public RegisterResponse register (@RequestBody RegisterRequest request) throws UserAlreadyExistException, PasswordMisMatchException {
        return adminService.register(request);
    }

    @PostMapping("login/")
    public LoginResponse login (@RequestBody LoginRequest request) throws UserDoesNotExistException {
        return adminService.login(request);
    }

}
