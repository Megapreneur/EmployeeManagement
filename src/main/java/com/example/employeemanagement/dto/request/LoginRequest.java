package com.example.employeemanagement.dto.request;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class LoginRequest {
    private String email;
    private String password;
}
