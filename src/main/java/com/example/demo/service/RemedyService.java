package com.example.demo.service;

import com.example.demo.abstractions.BaseCrudService;
import com.example.demo.entity.Remedy;
import com.example.demo.repository.IRemedyRepository;
import org.springframework.stereotype.Service;

@Service
public class RemedyService extends BaseCrudService<Remedy> {
    public RemedyService(IRemedyRepository repository) {
        super(repository);
    }
}
