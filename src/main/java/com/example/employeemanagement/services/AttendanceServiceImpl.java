package com.example.employeemanagement.services;

import com.example.employeemanagement.dto.request.SignInRequest;
import com.example.employeemanagement.dto.request.SignOutRequest;
import com.example.employeemanagement.dto.response.SignInResponse;
import com.example.employeemanagement.dto.response.SignOutResponse;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Override
    public SignInResponse signIn(SignInRequest request) {
        return null;
    }
    @Override
    public SignOutResponse signOut(SignOutRequest request) {
        return null;
    }
}
