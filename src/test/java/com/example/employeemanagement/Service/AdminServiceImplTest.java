package com.example.employeemanagement.Service;

import com.example.employeemanagement.data.models.enums.Gender;
import com.example.employeemanagement.data.models.enums.Role;
import com.example.employeemanagement.dto.request.LoginRequest;
import com.example.employeemanagement.dto.request.RegisterRequest;
import com.example.employeemanagement.dto.response.LoginResponse;
import com.example.employeemanagement.dto.response.RegisterResponse;
import com.example.employeemanagement.exceptions.PasswordMisMatchException;
import com.example.employeemanagement.exceptions.UserAlreadyExistException;
import com.example.employeemanagement.exceptions.UserDoesNotExistException;
import com.example.employeemanagement.services.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;
    @Test
    public void testThatAnAdminCanBeCreated() throws UserAlreadyExistException, PasswordMisMatchException {
        RegisterRequest request = RegisterRequest
                .builder()
                .name("Ademola Megbabi")
                .address("Juno Homes")
                .password("password")
                .email("ademolamegbabi@gmail.com")
                .role(Role.valueOf("ADMIN"))
                .gender(Gender.valueOf("MALE"))
                .confirmPassword("password")
                .phoneNumber("08137382895")
                .build();
        RegisterResponse response = adminService.register(request);
        assertEquals("Ademola Megbabi your registration was successful, you are now the admin.", response.getMessage());
    }

    @Test
    public void testThatAnAdminCanLogin() throws UserDoesNotExistException {
        LoginRequest request = LoginRequest.builder()
                .email("ademolamegbabi@gmail.com")
                .password("password")
                .build();
        LoginResponse response = adminService.login(request);
        assertEquals("Welcome Ademola Megbabi", response.getMessage());
    }

}