package com.example.demo.dto.Pharmacy;

import com.example.demo.interfaces.IBaseDTO;
import lombok.Data;

@Data
public class ResponsePharmacyDTO implements IBaseDTO {
    private Long id;

    private String name;

    private String address;
}
