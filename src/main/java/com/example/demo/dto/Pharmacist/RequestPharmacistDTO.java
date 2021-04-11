package com.example.demo.dto.Pharmacist;


import com.example.demo.interfaces.IBaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestPharmacistDTO implements IBaseDTO {
    private String name;
}
