package com.example.demo.dto.Remedy;

import com.example.demo.interfaces.IBaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestRemedyDTO implements IBaseDTO {
    private String name;

    private BigDecimal price;
}
