package com.example.demo.dto.Customer;


import com.example.demo.interfaces.IBaseDTO;
import lombok.Data;

@Data
public class ResponseCustomerDTO implements IBaseDTO {
    private Long id;

    private String name;

    private Double balance;
}
