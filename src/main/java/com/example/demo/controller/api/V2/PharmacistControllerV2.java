package com.example.demo.controller.api.V2;

import com.example.demo.controller.api.DtoBaseAPIController;
import com.example.demo.dto.Pharmacist.RequestPharmacistDTO;
import com.example.demo.dto.Pharmacist.ResponsePharmacistDTO;
import com.example.demo.entity.Pharmacist;
import com.example.demo.service.V2.PharmacistV2Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/pharmacist")
public class PharmacistControllerV2 extends DtoBaseAPIController<Pharmacist, RequestPharmacistDTO, ResponsePharmacistDTO> {
    public PharmacistControllerV2(PharmacistV2Service service) {
        super(service);
    }
}
