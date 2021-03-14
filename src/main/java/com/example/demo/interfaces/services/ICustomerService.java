package com.example.demo.interfaces.services;

import com.example.demo.dto.Customer.RequestCustomerDTO;
import com.example.demo.dto.Customer.ResponseCustomerDTO;
import com.example.demo.interfaces.IDtoCrudService;

public interface ICustomerService extends IDtoCrudService<RequestCustomerDTO, ResponseCustomerDTO> {
}
