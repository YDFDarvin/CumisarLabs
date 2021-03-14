package com.example.demo.service.V1;

import com.example.demo.entity.Purchase;
import com.example.demo.repository.IPurchaseRepository;
import com.example.demo.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService extends BaseCrudService<Purchase> {
    public PurchaseService(IPurchaseRepository repository) {
        super(repository);
    }
}
