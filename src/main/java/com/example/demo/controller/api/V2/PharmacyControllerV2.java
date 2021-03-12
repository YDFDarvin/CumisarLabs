package com.example.demo.controller.api.V2;

import com.example.demo.controller.api.DtoBaseAPIController;
import com.example.demo.dto.Pharmacy.RequestPharmacyDTO;
import com.example.demo.dto.Pharmacy.ResponsePharmacyDTO;
import com.example.demo.entity.Pharmacy;
import com.example.demo.service.V2.PharmacyV2Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/pharmacy")
public class PharmacyControllerV2 extends DtoBaseAPIController<Pharmacy, RequestPharmacyDTO, ResponsePharmacyDTO> {
    public PharmacyControllerV2(PharmacyV2Service service) {
        super(service);
    }
}
