package com.example.demo.controller.api.V2;


import com.example.demo.controller.api.DtoBaseAPIController;
import com.example.demo.dto.Purchase.RequestPurchaseDTO;
import com.example.demo.dto.Purchase.ResponsePurchaseDTO;
import com.example.demo.entity.Purchase;
import com.example.demo.service.V2.PurchaseV2Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/purchase")
public class PurchaseControllerV2 extends DtoBaseAPIController<Purchase, RequestPurchaseDTO, ResponsePurchaseDTO> {
    public PurchaseControllerV2(PurchaseV2Service service) {
        super(service);
    }
}
