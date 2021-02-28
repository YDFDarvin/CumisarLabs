package com.example.demo.service;

import com.example.demo.entity.Pharmacist;
import com.example.demo.repository.PharmacistRepository;
import org.springframework.stereotype.Service;

@Service
public class PharmacistService extends BaseCrudService<Pharmacist> {
    public PharmacistService(PharmacistRepository repository) {
        super(repository);
    }
}
