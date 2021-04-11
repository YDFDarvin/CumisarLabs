package com.example.demo.stabs;

import com.example.demo.dto.Customer.RequestCustomerDTO;
import com.example.demo.dto.Customer.ResponseCustomerDTO;
import com.example.demo.entity.Customer;

import java.util.ArrayList;

public class CustomerStab {
    public static final Long ID = 1L;
    public static Customer getCustomer() {
        return Customer.builder().id(ID).name("name").balance(.5d).purchases(new ArrayList<>()).build();
    }

    public static RequestCustomerDTO getRequestDto() {
        return RequestCustomerDTO.builder().name("name").balance(.5d).build();
    }

    public static ResponseCustomerDTO getResponseDto() {
        return ResponseCustomerDTO.builder().id(ID).name("name").balance(.5d).build();
    }
}
