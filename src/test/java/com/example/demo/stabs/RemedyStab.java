package com.example.demo.stabs;

import com.example.demo.dto.Remedy.RequestRemedyDTO;
import com.example.demo.dto.Remedy.ResponseRemedyDTO;
import com.example.demo.entity.Remedy;

import java.math.BigDecimal;
import java.util.ArrayList;

public class RemedyStab {
    public static final Long ID = 1L;
    public static Remedy getRemedy() {
        return Remedy.builder().id(ID).name("name").price(new BigDecimal(123)).purchases(new ArrayList<>()).category(RemedyCategoryStab.getRemedyCategory()).build();
    }

    public static RequestRemedyDTO getRequestDto() {
        return RequestRemedyDTO.builder().name("name").price(new BigDecimal(123)).build();
    }

    public static ResponseRemedyDTO getResponseDto() {
        return ResponseRemedyDTO.builder().id(ID).name("name").price(new BigDecimal(123)).category(RemedyCategoryStab.getResponseDto()).build();
    }
}
