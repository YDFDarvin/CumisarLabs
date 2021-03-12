package com.example.demo.service;

import com.example.demo.abstractions.BaseCrudService;
import com.example.demo.entity.Pharmacist;
import com.example.demo.repository.IPharmacistRepository;
import org.springframework.stereotype.Service;

@Service
public class PharmacistService extends BaseCrudService<Pharmacist> {
    public PharmacistService(IPharmacistRepository repository) {
        super(repository);
    }
}
