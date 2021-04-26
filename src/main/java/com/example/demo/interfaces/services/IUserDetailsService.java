package com.example.demo.interfaces.services;

import com.example.demo.entity.Customer;
import javassist.NotFoundException;

public interface IUserDetailsService {
    Customer loadUserByEmail(String email) throws NotFoundException;
}
