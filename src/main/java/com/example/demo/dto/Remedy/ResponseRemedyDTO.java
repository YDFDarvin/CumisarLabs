package com.example.demo.dto.Remedy;

import com.example.demo.dto.RemedyCategory.ResponseRemedyCategoryDTO;
import com.example.demo.interfaces.IBaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseRemedyDTO implements IBaseDTO {
    private Long id;

    private String name;

    private BigDecimal price;

    private ResponseRemedyCategoryDTO category;
}
