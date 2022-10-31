package com.example.employeemanagement.data.repositories;

import com.example.employeemanagement.data.models.Employee;
import com.example.employeemanagement.dto.response.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByEmail(String email);

    boolean existsByEmail(String email);
    @Query("SELECT new com.example.employeemanagement.dto.response.EmployeeDto (employee.employeeId, employee.firstName, employee.lastName,employee.gender, employee.address, employee.department )from Employee employee")
    List<EmployeeDto> findAllEmployee();
    Optional<Employee> findEmployeeByEmployeeId(String id);

}
