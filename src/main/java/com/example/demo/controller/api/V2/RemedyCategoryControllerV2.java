package com.example.demo.controller.api.V2;

import com.example.demo.abstractions.BaseCrudControllerDTO;
import com.example.demo.dto.RemedyCategory.RemedyCategoryModelMapper;
import com.example.demo.dto.RemedyCategory.RequestRemedyCategoryDTO;
import com.example.demo.dto.RemedyCategory.ResponseRemedyCategoryDTO;
import com.example.demo.entity.RemedyCategory;
import com.example.demo.service.RemedyCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/remedy_category")
public class RemedyCategoryControllerV2 extends BaseCrudControllerDTO<RemedyCategory, RequestRemedyCategoryDTO, ResponseRemedyCategoryDTO> {
    public RemedyCategoryControllerV2(RemedyCategoryService service, RemedyCategoryModelMapper modelMapper) {
        super(service, modelMapper);
    }
}
