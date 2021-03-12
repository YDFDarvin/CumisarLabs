package com.example.demo.service;

import com.example.demo.abstractions.BaseCrudService;
import com.example.demo.entity.Pharmacy;
import com.example.demo.repository.IPharmacyRepository;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService extends BaseCrudService<Pharmacy> {
    public PharmacyService(IPharmacyRepository repository) {
        super(repository);
    }
}
