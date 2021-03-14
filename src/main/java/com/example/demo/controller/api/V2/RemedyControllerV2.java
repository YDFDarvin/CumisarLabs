package com.example.demo.controller.api.V2;

import com.example.demo.controller.api.DtoBaseAPIController;
import com.example.demo.dto.Remedy.RequestRemedyDTO;
import com.example.demo.dto.Remedy.ResponseRemedyDTO;
import com.example.demo.entity.Remedy;
import com.example.demo.service.V2.RemedyV2Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/remedy")
public class RemedyControllerV2 extends DtoBaseAPIController<Remedy, RequestRemedyDTO, ResponseRemedyDTO> {
    public RemedyControllerV2(RemedyV2Service service) {
        super(service);
    }
}
