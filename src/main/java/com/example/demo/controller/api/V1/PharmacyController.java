package com.example.demo.controller.api.V1;

import com.example.demo.controller.api.BaseCrudController;
import com.example.demo.entity.Pharmacy;
import com.example.demo.service.PharmacyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pharmacy")
public class PharmacyController extends BaseCrudController<Pharmacy> {
    public PharmacyController(PharmacyService service) {
        super(service);
    }
}
