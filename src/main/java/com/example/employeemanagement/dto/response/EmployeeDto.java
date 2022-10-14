package com.example.employeemanagement.dto.response;

import com.example.employeemanagement.data.models.enums.Department;
import com.example.employeemanagement.data.models.enums.Gender;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String address;
    private Department department;



}
