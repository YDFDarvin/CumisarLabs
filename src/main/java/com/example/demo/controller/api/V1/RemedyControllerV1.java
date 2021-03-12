package com.example.demo.controller.api.V1;

import com.example.demo.abstractions.BaseCrudController;
import com.example.demo.entity.Remedy;
import com.example.demo.service.RemedyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/remedy")
public class RemedyControllerV1 extends BaseCrudController<Remedy> {
    public RemedyControllerV1(RemedyService service) {
        super(service);
    }
}
