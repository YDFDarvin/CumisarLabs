package com.example.demo.stabs;

import com.example.demo.dto.Pharmacy.RequestPharmacyDTO;
import com.example.demo.dto.Pharmacy.ResponsePharmacyDTO;
import com.example.demo.entity.Pharmacy;

import java.util.ArrayList;

public class PharmacyStab {
    public static final Long ID = 1L;
    public static Pharmacy getPharmacy() {
        return Pharmacy.builder().id(ID).name("name").address("address").purchases(new ArrayList<>()).build();
    }

    public static RequestPharmacyDTO getRequestDto() {
        return RequestPharmacyDTO.builder().name("name").address("address").build();
    }

    public static ResponsePharmacyDTO getResponseDto() {
        return ResponsePharmacyDTO.builder().id(ID).name("name").address("address").build();
    }
}
