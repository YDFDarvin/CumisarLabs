package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseCrudService<Customer> {
    public CustomerService(CustomerRepository repository) {
        super(repository);
    }
}
