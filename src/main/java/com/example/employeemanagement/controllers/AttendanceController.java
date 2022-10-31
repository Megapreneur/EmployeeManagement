package com.example.employeemanagement.controllers;

import com.example.employeemanagement.dto.request.SignInRequest;
import com.example.employeemanagement.dto.request.SignOutRequest;
import com.example.employeemanagement.dto.response.SignInResponse;
import com.example.employeemanagement.dto.response.SignOutResponse;
import com.example.employeemanagement.exceptions.EmployeeManagementException;
import com.example.employeemanagement.services.Attendance.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/employee/attendance/")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("signIn/")
    public SignInResponse signIn(@RequestBody SignInRequest request) throws EmployeeManagementException {
        return attendanceService.signIn(request);
    }
    @PostMapping("signOut/")
    public SignOutResponse signOut(@RequestBody SignOutRequest request) throws EmployeeManagementException {
        return attendanceService.signOut(request);
    }
}
