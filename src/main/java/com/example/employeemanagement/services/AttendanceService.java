package com.example.employeemanagement.services;

import com.example.employeemanagement.dto.request.SignInRequest;
import com.example.employeemanagement.dto.request.SignOutRequest;
import com.example.employeemanagement.dto.response.SignInResponse;
import com.example.employeemanagement.dto.response.SignOutResponse;

public interface AttendanceService {
    SignInResponse signIn(SignInRequest request);
    SignOutResponse signOut(SignOutRequest request);
}
