package com.example.employeemanagement.services.Admin;

import com.example.employeemanagement.Configuration.SecureAdmin;
import com.example.employeemanagement.data.models.Admin;
import com.example.employeemanagement.data.repositories.AdminRepository;
import com.example.employeemanagement.dto.request.LoginRequest;
import com.example.employeemanagement.dto.response.LoginResponse;
import com.example.employeemanagement.dto.request.RegisterRequest;
import com.example.employeemanagement.dto.response.RegisterResponse;
import com.example.employeemanagement.exceptions.InvalidEmailException;
import com.example.employeemanagement.exceptions.PasswordMisMatchException;
import com.example.employeemanagement.exceptions.UserAlreadyExistException;
import com.example.employeemanagement.exceptions.UserDoesNotExistException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.employeemanagement.utils.ValidateEmail.isValidEmail;

@Service
public class AdminServiceImpl implements AdminService, UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public RegisterResponse register(RegisterRequest request) throws UserAlreadyExistException, PasswordMisMatchException, InvalidEmailException {
       if (isValidEmail(request.getEmail())){
           if (!adminRepository.existsByEmail(request.getEmail())){
               Admin admin = mapper.map(request,Admin.class);
               admin.setPassword(passwordEncoder.encode(request.getPassword()));
               if (request.getPassword().equals(request.getConfirmPassword())){
                   adminRepository.save(admin);
                   return RegisterResponse
                           .builder()
                           .message(admin.getName() + " your registration was successful, you are now the admin.")
                           .build();
               }
               throw new PasswordMisMatchException("Your password does not match!!!", HttpStatus.NOT_ACCEPTABLE);
           }
           throw new UserAlreadyExistException("User already exist!!!", HttpStatus.FORBIDDEN);
       }
       throw new InvalidEmailException("Invalid email syntax!!!", HttpStatus.FORBIDDEN);
    }

    @Override
    public LoginResponse login(LoginRequest request) throws UserDoesNotExistException {
        Optional<Admin> admin = adminRepository.findByEmail(request.getEmail());
        if (admin.isPresent()){
            if (passwordEncoder.matches(request.getPassword(), admin.get().getPassword())){
                return LoginResponse
                        .builder()
                        .message("Welcome " + admin.get().getName())
                        .build();
            }
            throw new UserDoesNotExistException("Invalid login Details", HttpStatus.NOT_FOUND);
        }
        throw new UserDoesNotExistException("Invalid login Details", HttpStatus.NOT_FOUND);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Admin not found"));
        return new SecureAdmin(admin);
    }
}

