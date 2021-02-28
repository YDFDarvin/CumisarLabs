package com.example.demo.service;

import com.example.demo.entity.Pharmacy;
import com.example.demo.repository.PharmacyRepository;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService extends BaseCrudService<Pharmacy>  {
    public PharmacyService(PharmacyRepository repository) {
        super(repository);
    }
}
