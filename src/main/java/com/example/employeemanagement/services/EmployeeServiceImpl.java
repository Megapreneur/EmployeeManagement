package com.example.employeemanagement.services;

import com.example.employeemanagement.data.models.Admin;
import com.example.employeemanagement.data.models.Employee;
import com.example.employeemanagement.data.models.enums.Role;
import com.example.employeemanagement.data.repositories.AdminRepository;
import com.example.employeemanagement.data.repositories.EmployeeRepository;
import com.example.employeemanagement.dto.request.AddRequest;
import com.example.employeemanagement.dto.request.UpdateRequest;
import com.example.employeemanagement.dto.response.AddResponse;
import com.example.employeemanagement.dto.response.UpdateResponse;
import com.example.employeemanagement.exceptions.EmployeeAlreadyExistException;
import com.example.employeemanagement.exceptions.PasswordMisMatchException;
import com.example.employeemanagement.exceptions.UauthorizedUserException;
import com.example.employeemanagement.exceptions.UserDoesNotExistException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final AdminRepository adminRepository;
    private final EmployeeRepository employeeRepository;
    private  final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public AddResponse addEmployee(AddRequest request) throws UserDoesNotExistException, UauthorizedUserException, EmployeeAlreadyExistException, PasswordMisMatchException {
        Optional<Admin>admin = adminRepository.findByEmail(request.getAdminEmail());
        if (admin.isPresent()) {
            if (passwordEncoder.matches(request.getPassword(), admin.get().getPassword())){
                if (admin.get().getRole().equals(Role.ADMIN)){
                    if (!employeeRepository.existsByEmail(request.getEmail())){
                        Employee employee = mapper.map(request, Employee.class);
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

    @Override
    public UpdateResponse updateEmployee(UpdateRequest request) throws UserDoesNotExistException {
        if (adminRepository.existsByEmail(request.getAdminEmail())){
            Optional<Employee> employee = employeeRepository.findEmployeeByEmail(request.getEmail());



        }
        throw new UserDoesNotExistException("Invalid login Details", HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}

