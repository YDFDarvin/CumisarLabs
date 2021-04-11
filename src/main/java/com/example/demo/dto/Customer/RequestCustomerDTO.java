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
public class RequestCustomerDTO implements IBaseDTO {
    private String name;

    private Double balance;
}
