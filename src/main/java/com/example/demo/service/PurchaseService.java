package com.example.demo.service;

import com.example.demo.entity.Purchase;
import com.example.demo.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService extends BaseCrudService<Purchase>  {
    public PurchaseService(PurchaseRepository repository) {
        super(repository);
    }
}
