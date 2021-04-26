package com.example.demo.controller.api.V2;

import com.example.demo.dto.Customer.RequestCustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.service.V2.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v2/auth")
public class AuthV2ApiController {
    private final AuthService service;

    public void createUser(){
        var userRequest = new RequestCustomerDTO();
        userRequest.setEmail("user@test.com");
        userRequest.setPassword("user");
        service.createUser(userRequest,"ROLE_USER");
        var adminRequest = new RequestCustomerDTO();
        adminRequest.setEmail("admin@test.com");
        adminRequest.setPassword("admin");
        service.createUser(adminRequest, "ROLE_ADMIN");
    }


    @PostMapping("/createUser")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<Customer> registerUser(RequestCustomerDTO userDto){
        return  ResponseEntity.ok(service.createUser(userDto, "ROLE_USER"));
    }
    @PostMapping("/createAdmin")
    public ResponseEntity<Customer> registerAdmin(RequestCustomerDTO userDto){
        return  ResponseEntity.ok(service.createUser(userDto,"ROLE_ADMIN"));
    }
    @PostMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<String> login(@RequestBody RequestCustomerDTO userRequest){
        return ResponseEntity.ok(service.createToken(userRequest));
    }
}
