package com.example.demo.controller.api.V1;

import com.example.demo.controller.api.BaseCrudController;
import com.example.demo.entity.Pharmacist;
import com.example.demo.service.PharmacistService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pharmacist")
public class PharmacistController extends BaseCrudController<Pharmacist> {
    public PharmacistController(PharmacistService service) {
        super(service);
    }
}
