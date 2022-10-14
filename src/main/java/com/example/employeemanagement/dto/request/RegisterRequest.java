package com.example.employeemanagement.dto.request;

import com.example.employeemanagement.data.models.enums.Gender;
import com.example.employeemanagement.data.models.enums.Role;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private Gender gender;
    private Role role;
    private String password;
    private String confirmPassword;
}
