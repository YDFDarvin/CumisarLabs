package com.example.demo.controller.api.V2;

import com.example.demo.controller.api.DtoBaseAPIController;
import com.example.demo.dto.RemedyCategory.RequestRemedyCategoryDTO;
import com.example.demo.dto.RemedyCategory.ResponseRemedyCategoryDTO;
import com.example.demo.entity.RemedyCategory;
import com.example.demo.service.V2.RemedyCategoryV2Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/remedy_category")
public class RemedyCategoryControllerV2 extends DtoBaseAPIController<RemedyCategory, RequestRemedyCategoryDTO, ResponseRemedyCategoryDTO> {
    public RemedyCategoryControllerV2(RemedyCategoryV2Service service) {
        super(service);
    }
}
