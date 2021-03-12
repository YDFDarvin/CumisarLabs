package com.example.demo.service.V1;

import com.example.demo.entity.Pharmacy;
import com.example.demo.repository.IPharmacyRepository;
import com.example.demo.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService extends BaseCrudService<Pharmacy> {
    public PharmacyService(IPharmacyRepository repository) {
        super(repository);
    }
}
