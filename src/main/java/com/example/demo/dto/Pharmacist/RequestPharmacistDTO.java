package com.example.demo.dto.Pharmacist;


import com.example.demo.interfaces.IBaseDTO;
import lombok.Data;

@Data
public class RequestPharmacistDTO implements IBaseDTO {
    private String name;
}
