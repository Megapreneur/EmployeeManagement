package com.example.employeemanagement.data.models;

import lombok.*;

import javax.persistence.*;
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
    private LocalDateTime signIn;
    private LocalDateTime signOut;
    private LocalDateTime sickLeave;
    private LocalDateTime absence;
    @ManyToOne
    @JoinColumn
    private Employee employee;
}
