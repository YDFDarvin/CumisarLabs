package com.example.demo.service;

import com.example.demo.abstractions.BaseCrudService;
import com.example.demo.entity.Purchase;
import com.example.demo.repository.IPurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService extends BaseCrudService<Purchase> {
    public PurchaseService(IPurchaseRepository repository) {
        super(repository);
    }
}
