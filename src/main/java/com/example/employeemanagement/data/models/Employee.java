package com.example.employeemanagement.data.models;

import com.example.employeemanagement.data.models.enums.Department;
import com.example.employeemanagement.data.models.enums.Gender;
import com.example.employeemanagement.data.models.enums.Role;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Email
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Department department;
    @Column(unique = true, name = "employeeId")
    private String employeeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate resumptionDate;

}
