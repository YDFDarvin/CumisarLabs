package com.example.demo.dto.RemedyCategory;

import com.example.demo.interfaces.IBaseDTO;
import lombok.Data;

@Data
public class ResponseRemedyCategoryDTO implements IBaseDTO {
    private Long id;

    private String name;

    private String description;
}
