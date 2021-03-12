package com.example.demo.controller.api.V1;

import com.example.demo.controller.api.BaseAPIController;
import com.example.demo.entity.RemedyCategory;
import com.example.demo.service.V1.RemedyCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/remedy_category")
public class RemedyCategoryControllerV1 extends BaseAPIController<RemedyCategory> {
    public RemedyCategoryControllerV1(RemedyCategoryService service) {
        super(service);
    }
}
