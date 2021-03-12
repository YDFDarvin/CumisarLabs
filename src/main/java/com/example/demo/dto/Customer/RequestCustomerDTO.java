package com.example.demo.dto.Customer;

import com.example.demo.interfaces.dto.IBaseDTO;
import lombok.Data;

@Data
public class RequestCustomerDTO implements IBaseDTO {
    private String name;

    private Double balance;
}
