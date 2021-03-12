package com.example.demo.dto.Pharmacy;

import com.example.demo.interfaces.IBaseDTO;
import lombok.Data;

@Data
public class RequestPharmacyDTO implements IBaseDTO {
    private String name;

    private String address;
}
