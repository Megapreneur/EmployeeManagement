package com.example.employeemanagement.services;

import com.example.employeemanagement.dto.request.SignInRequest;
import com.example.employeemanagement.dto.request.SignOutRequest;
import com.example.employeemanagement.dto.response.SignInResponse;
import com.example.employeemanagement.dto.response.SignOutResponse;
import com.example.employeemanagement.exceptions.EmployeeManagementException;

public interface AttendanceService {
    SignInResponse signIn(SignInRequest request) throws EmployeeManagementException;
    SignOutResponse signOut(SignOutRequest request) throws EmployeeManagementException;
}
