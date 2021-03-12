package com.example.demo.service.V1;

import com.example.demo.entity.Pharmacist;
import com.example.demo.repository.IPharmacistRepository;
import com.example.demo.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class PharmacistService extends BaseCrudService<Pharmacist> {
    public PharmacistService(IPharmacistRepository repository) {
        super(repository);
    }
}
