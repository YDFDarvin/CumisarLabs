package com.example.demo.stabs;

import com.example.demo.dto.RemedyCategory.RequestRemedyCategoryDTO;
import com.example.demo.dto.RemedyCategory.ResponseRemedyCategoryDTO;
import com.example.demo.entity.RemedyCategory;

import java.util.ArrayList;

public class RemedyCategoryStab {
    public static final Long ID = 1L;
    public static RemedyCategory getRemedyCategory() {
        return RemedyCategory.builder().id(ID).name("name").description("description").remedies(new ArrayList<>()).build();
    }

    public static RequestRemedyCategoryDTO getRequestDto() {
        return RequestRemedyCategoryDTO.builder().name("name").description("description").build();
    }

    public static ResponseRemedyCategoryDTO getResponseDto() {
        return ResponseRemedyCategoryDTO.builder().id(ID).name("name").description("description").build();
    }
}
