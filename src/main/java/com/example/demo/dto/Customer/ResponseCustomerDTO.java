package com.example.demo.dto.Customer;


import com.example.demo.interfaces.IBaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCustomerDTO implements IBaseDTO {
    private Long id;

    private String name;

    private Double balance;
}
