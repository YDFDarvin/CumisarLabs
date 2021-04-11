package com.example.demo.stabs;

import com.example.demo.dto.Pharmacist.RequestPharmacistDTO;
import com.example.demo.dto.Pharmacist.ResponsePharmacistDTO;
import com.example.demo.entity.Pharmacist;

import java.util.ArrayList;

public class PharmacistStab {
    public static final Long ID = 1L;
    public static Pharmacist getPharmacist() {
        return Pharmacist.builder().id(ID).name("name").purchases(new ArrayList<>()).build();
    }

    public static RequestPharmacistDTO getRequestDto() {
        return RequestPharmacistDTO.builder().name("name").build();
    }

    public static ResponsePharmacistDTO getResponseDto() {
        return ResponsePharmacistDTO.builder().id(ID).name("name").build();
    }
}
