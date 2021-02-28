package com.example.demo.controller.api.V1;

import com.example.demo.controller.api.BaseCrudController;
import com.example.demo.entity.RemedyCategory;
import com.example.demo.service.RemedyCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/remedy_category")
public class RemedyCategoryController extends BaseCrudController<RemedyCategory> {
    public RemedyCategoryController(RemedyCategoryService service) {
        super(service);
    }
}
