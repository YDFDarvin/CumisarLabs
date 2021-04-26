package com.example.demo.service.V2;

import com.example.demo.dto.Customer.RequestCustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Role;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final ICustomerRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public Customer createUser(RequestCustomerDTO userRequest, String role) {
        var roles = new HashSet<Role>();
        var build = roleRepo.findByName(role);
        roles.add(build.orElseThrow());
        var user = Customer.builder()
                .email(userRequest
                        .getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .roles(roles)
                .build();
        return userRepo.save(user);
    }

    public String createToken(RequestCustomerDTO request) {
        var authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        return jwtUtils.generateJwtToken(authenticate);
    }
}
