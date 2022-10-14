package com.example.employeemanagement.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {
    private String adminEmail;
    private String email;
}
