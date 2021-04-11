package com.example.demo.dto.RemedyCategory;

import com.example.demo.interfaces.IBaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestRemedyCategoryDTO implements IBaseDTO {
    private String name;

    private String description;
}
