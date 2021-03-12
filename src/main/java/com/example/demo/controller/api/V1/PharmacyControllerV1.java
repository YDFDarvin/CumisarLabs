package com.example.demo.controller.api.V1;

import com.example.demo.controller.api.BaseAPIController;
import com.example.demo.entity.Pharmacy;
import com.example.demo.service.V1.PharmacyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pharmacy")
public class PharmacyControllerV1 extends BaseAPIController<Pharmacy> {
    public PharmacyControllerV1(PharmacyService service) {
        super(service);
    }
}
