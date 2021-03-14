package com.example.demo.dto.RemedyCategory;

import com.example.demo.interfaces.IBaseDTO;
import lombok.Data;

@Data
public class RequestRemedyCategoryDTO implements IBaseDTO {
    private String name;

    private String description;
}
