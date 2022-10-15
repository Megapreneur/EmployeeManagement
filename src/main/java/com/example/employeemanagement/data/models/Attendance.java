package com.example.employeemanagement.data.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime signIn;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime signOut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sickLeave;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate absence;
    @ManyToOne
    @JoinColumn
    private Employee employee;
}
