package com.example.demo.controller.api.V1;

import com.example.demo.controller.api.BaseCrudController;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController extends BaseCrudController<Customer> {
    public CustomerController(CustomerService service) {
        super(service);
    }
}
