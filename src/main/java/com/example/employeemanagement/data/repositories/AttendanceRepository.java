package com.example.employeemanagement.data.repositories;

import com.example.employeemanagement.data.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance , Long> {
    Optional<Attendance> findEmployeeByEmployeeId(long id);
}
