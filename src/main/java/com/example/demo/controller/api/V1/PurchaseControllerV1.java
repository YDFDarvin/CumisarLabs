package com.example.demo.controller.api.V1;

import com.example.demo.abstractions.BaseCrudController;
import com.example.demo.entity.Purchase;
import com.example.demo.service.PurchaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseControllerV1 extends BaseCrudController<Purchase> {
    public PurchaseControllerV1(PurchaseService service) {
        super(service);
    }
}
