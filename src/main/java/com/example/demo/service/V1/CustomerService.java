package com.example.demo.service.V1;

import com.example.demo.entity.Customer;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseCrudService<Customer> {
    public CustomerService(ICustomerRepository repository) {
        super(repository);
    }
}
