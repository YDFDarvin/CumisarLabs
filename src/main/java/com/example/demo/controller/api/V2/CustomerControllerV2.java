package com.example.demo.controller.api.V2;

import com.example.demo.controller.api.DtoBaseAPIController;
import com.example.demo.dto.Customer.RequestCustomerDTO;
import com.example.demo.dto.Customer.ResponseCustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.service.V2.CustomerV2Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/customer")
public class CustomerControllerV2 extends DtoBaseAPIController<Customer, RequestCustomerDTO, ResponseCustomerDTO> {
    public CustomerControllerV2(CustomerV2Service service) {
        super(service);
    }
}
