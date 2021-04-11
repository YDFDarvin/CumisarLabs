package com.example.demo.stabs;


import com.example.demo.dto.RemedyCategory.RequestRemedyCategoryDTO;
import com.example.demo.dto.RemedyCategory.ResponseRemedyCategoryDTO;
import com.example.demo.entity.RemedyCategory;

import java.util.ArrayList;

public final class RemedyCategoryStab {
    public static final Long ID = 1L;
    public static RemedyCategory getUser() {
        return RemedyCategory.builder().id(ID).description("description").name("name").remedies(new ArrayList<>()).build();
    }

    public static RequestRemedyCategoryDTO getRequestDto() {
        return RequestRemedyCategoryDTO.builder().description("description").name("name").build();
    }

    public static ResponseRemedyCategoryDTO getResponseDto() {
        return ResponseRemedyCategoryDTO.builder().id(ID).description("description").name("name").build();
    }
}
