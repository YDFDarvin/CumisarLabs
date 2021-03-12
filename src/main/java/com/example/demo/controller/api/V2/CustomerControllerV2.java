package com.example.demo.controller.api.V2;

import com.example.demo.abstractions.BaseCrudControllerDTO;
import com.example.demo.dto.Customer.CustomerModelMapper;
import com.example.demo.dto.Customer.RequestCustomerDTO;
import com.example.demo.dto.Customer.ResponseCustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/customer")
public class CustomerControllerV2 extends BaseCrudControllerDTO<Customer, RequestCustomerDTO, ResponseCustomerDTO> {
    public CustomerControllerV2(CustomerService service, CustomerModelMapper modelMapper) {
        super(service, modelMapper);
    }
}
