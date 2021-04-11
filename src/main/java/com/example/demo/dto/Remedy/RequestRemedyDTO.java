package com.example.demo.dto.Remedy;

import com.example.demo.interfaces.IBaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestRemedyDTO implements IBaseDTO {
    private String name;

    private BigDecimal price;
}
