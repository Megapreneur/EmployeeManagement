package com.example.employeemanagement.services;

import com.example.employeemanagement.data.models.Attendance;
import com.example.employeemanagement.data.models.Employee;
import com.example.employeemanagement.data.repositories.AttendanceRepository;
import com.example.employeemanagement.data.repositories.EmployeeRepository;
import com.example.employeemanagement.dto.request.SignInRequest;
import com.example.employeemanagement.dto.request.SignOutRequest;
import com.example.employeemanagement.dto.response.SignInResponse;
import com.example.employeemanagement.dto.response.SignOutResponse;
import com.example.employeemanagement.exceptions.EmployeeManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Override
    public SignInResponse signIn(SignInRequest request) throws EmployeeManagementException {
        Optional<Employee> employee = employeeRepository.findEmployeeById(request.getEmployeeId());
        if (employee.isPresent()){
            Attendance today = Attendance.builder()
                    .signIn(request.getTime())
                    .build();
            attendanceRepository.save(today);
            return SignInResponse.builder()
                    .message(employee.get().getFirstName() + ", you have signed in successfully. Do have a great day at work.")
                    .build();
        }
        throw new EmployeeManagementException("Invalid Employee Id!!!", HttpStatus.NOT_FOUND);
    }
    @Override
    public SignOutResponse signOut(SignOutRequest request) throws EmployeeManagementException {
        Optional<Employee> employee = employeeRepository.findEmployeeById(request.getEmployeeId());
        if (employee.isPresent()){
            Attendance today = Attendance.builder()
                    .signOut(request.getTime())
                    .build();
            attendanceRepository.save(today);
            return SignOutResponse.builder()
                    .message(employee.get().getFirstName() + ", you have signed out successfully. Do have a safe trip back home and see you tomorrow.")
                    .build();
        }
        throw new EmployeeManagementException("Invalid Employee Id!!!", HttpStatus.NOT_FOUND);
    }
}
