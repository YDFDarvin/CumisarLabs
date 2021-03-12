package com.example.demo.dto.Pharmacist;


import com.example.demo.interfaces.IBaseDTO;
import lombok.Data;

@Data
public class ResponsePharmacistDTO implements IBaseDTO {
    private Long id;

    private String name;
}
