package com.example.employeemanagement.Service;

import com.example.employeemanagement.data.models.enums.Department;
import com.example.employeemanagement.data.models.enums.Gender;
import com.example.employeemanagement.data.models.enums.Role;
import com.example.employeemanagement.dto.request.AddRequest;
import com.example.employeemanagement.dto.response.AddResponse;
import com.example.employeemanagement.exceptions.EmployeeAlreadyExistException;
import com.example.employeemanagement.exceptions.PasswordMisMatchException;
import com.example.employeemanagement.exceptions.UauthorizedUserException;
import com.example.employeemanagement.exceptions.UserDoesNotExistException;
import com.example.employeemanagement.services.Employee.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceImplTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testThatAnAdminCanAddANewEmployee() throws UauthorizedUserException, UserDoesNotExistException, PasswordMisMatchException, EmployeeAlreadyExistException {
        AddRequest request = AddRequest.builder()
                .firstName("John")
                .lastName("David")
                .address("17, moshood tijani street")
                .password("password")
                .adminEmail("ademolamegbabi@gmail.com")
                .role(Role.valueOf("EMPLOYEE"))
                .email("jd@gmail.com")
                .department(Department.valueOf("IT"))
                .gender(Gender.valueOf("MALE"))
                .phoneNumber("09066464322")
                .build();
        AddResponse response = employeeService.addEmployee(request);
        assertEquals("You have success added John David to the company's database system.", response.getMessage());
    }

    @Test
    public void testThatAnAdminCanAddANewEmployeeAgain() throws UauthorizedUserException, UserDoesNotExistException, PasswordMisMatchException, EmployeeAlreadyExistException {
        AddRequest request = AddRequest.builder()
                .firstName("Selina")
                .lastName("Ngozi")
                .address("17, kano street")
                .password("password")
                .adminEmail("ademolamegbabi@gmail.com")
                .role(Role.valueOf("EMPLOYEE"))
                .email("sn@gmail.com")
                .department(Department.valueOf("FINANCE"))
                .gender(Gender.valueOf("FEMALE"))
                .phoneNumber("09066828363")
                .build();
        AddResponse response = employeeService.addEmployee(request);
        assertEquals("You have success added Selina Ngozi to the company's database system.", response.getMessage());
    }

}