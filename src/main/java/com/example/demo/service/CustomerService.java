package com.example.demo.service;

import com.example.demo.abstractions.BaseCrudService;
import com.example.demo.entity.Customer;
import com.example.demo.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseCrudService<Customer> {
    public CustomerService(ICustomerRepository repository) {
        super(repository);
    }
}
