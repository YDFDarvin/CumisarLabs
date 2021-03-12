package com.example.demo.controller.api.V1;

import com.example.demo.controller.api.BaseAPIController;
import com.example.demo.entity.Purchase;
import com.example.demo.service.V1.PurchaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseControllerV1 extends BaseAPIController<Purchase> {
    public PurchaseControllerV1(PurchaseService service) {
        super(service);
    }
}
