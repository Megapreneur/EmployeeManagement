package com.example.employeemanagement.dto.request;

import com.example.employeemanagement.data.models.enums.Department;
import com.example.employeemanagement.data.models.enums.Gender;
import com.example.employeemanagement.data.models.enums.Role;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddRequest {
    private String adminEmail;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Gender gender;
    private Role role;
    private Department department;

}
