package com.example.demo.service;

import com.example.demo.entity.Remedy;
import com.example.demo.repository.RemedyRepository;
import org.springframework.stereotype.Service;

@Service
public class RemedyService extends BaseCrudService<Remedy> {
    public RemedyService(RemedyRepository repository) {
        super(repository);
    }
}
