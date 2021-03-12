package com.example.demo.controller.api.V1;

import com.example.demo.controller.api.BaseAPIController;
import com.example.demo.entity.Pharmacist;
import com.example.demo.service.V1.PharmacistService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pharmacist")
public class PharmacistControllerV1 extends BaseAPIController<Pharmacist> {
    public PharmacistControllerV1(PharmacistService service) {
        super(service);
    }
}
