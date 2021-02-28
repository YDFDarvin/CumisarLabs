package com.example.demo.controller.api.V1;

import com.example.demo.controller.api.BaseCrudController;
import com.example.demo.entity.Remedy;
import com.example.demo.service.RemedyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/remedy")
public class RemedyController extends BaseCrudController<Remedy> {
    public RemedyController(RemedyService service) {
        super(service);
    }
}
