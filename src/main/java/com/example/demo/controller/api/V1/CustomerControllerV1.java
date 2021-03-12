package com.example.demo.controller.api.V1;

import com.example.demo.controller.api.BaseAPIController;
import com.example.demo.entity.Customer;
import com.example.demo.service.V1.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerControllerV1 extends BaseAPIController<Customer> {
    public CustomerControllerV1(CustomerService service) {
        super(service);
    }
}
