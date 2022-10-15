package com.example.employeemanagement.services;

import com.example.employeemanagement.data.models.Admin;
import com.example.employeemanagement.data.models.Employee;
import com.example.employeemanagement.data.models.enums.Role;
import com.example.employeemanagement.data.repositories.AdminRepository;
import com.example.employeemanagement.data.repositories.EmployeeRepository;
import com.example.employeemanagement.dto.request.AddRequest;
import com.example.employeemanagement.dto.request.UpdateRequest;
import com.example.employeemanagement.dto.response.AddResponse;
import com.example.employeemanagement.dto.response.EmployeeDto;
import com.example.employeemanagement.dto.response.UpdateResponse;
import com.example.employeemanagement.exceptions.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private  ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public AddResponse addEmployee(AddRequest request) throws UserDoesNotExistException, UauthorizedUserException, EmployeeAlreadyExistException, PasswordMisMatchException {
        Optional<Admin>admin = adminRepository.findByEmail(request.getAdminEmail());
        if (admin.isPresent()) {
            if (passwordEncoder.matches(request.getPassword(), admin.get().getPassword())){
                if (admin.get().getRole().equals(Role.ADMIN)){
                    if (!employeeRepository.existsByEmail(request.getEmail())){
                        Employee employee = mapper.map(request, Employee.class);
                        employee.setEmployeeId(generateEmployeeId(employee));
                        Employee savedEmployee = employeeRepository.save(employee);
                        return AddResponse
                                .builder()
                                .message("You have success added " + savedEmployee.getFirstName() + " " +
                                        savedEmployee.getLastName() + " to the company's database system.")
                                .build();
                    }
                    throw new EmployeeAlreadyExistException("An employee with " + request.getEmail() + " already exist.", HttpStatus.FORBIDDEN );
                } 
                throw  new UauthorizedUserException("You are not authorized to add employee", HttpStatus.NOT_ACCEPTABLE);
            }
            throw new PasswordMisMatchException("Invalid login details.", HttpStatus.NOT_ACCEPTABLE);
        }
        throw new UserDoesNotExistException("Invalid admin account.", HttpStatus.NOT_ACCEPTABLE);
    }
    private String generateEmployeeId(Employee employee){
        String id = String.valueOf(UUID.randomUUID().getMostSignificantBits());
        switch (employee.getDepartment()){
            case IT -> id = id.substring(1, 4) + "ITD";
            case CUSTOMER_SERVICE -> id = id.substring(1, 4) + "CSD";
            case FINANCE -> id = id.substring(1, 4) + "FND";
            case LOGISTIC -> id = id.substring(1, 4) + "LOG";
            case SECURITY -> id = id.substring(1, 4) + "SEC";
            case OPERATIONS -> id = id.substring(1, 4) + "OPT";
            case PROCUREMENT -> id = id.substring(1, 4) + "PRD";
        }
        return id;
    }

    @Override
    public UpdateResponse updateEmployee(UpdateRequest request) throws UserDoesNotExistException {
        if (adminRepository.existsByEmail(request.getAdminEmail())){
            Optional<Employee> employee = employeeRepository.findEmployeeByEmail(request.getEmail());



        }
        throw new UserDoesNotExistException("Invalid login Details", HttpStatus.NOT_FOUND);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAllEmployee();
    }

    @Override
    public Optional<Employee> findEmployee(String employeeId) throws EmployeeManagementException {
        Optional<Employee> employee = employeeRepository.findEmployeeById(employeeId);
        if (employee.isPresent()){
            return employee;
        }
        throw new EmployeeManagementException("No employee with that Id", HttpStatus.NOT_FOUND);
    }
}

