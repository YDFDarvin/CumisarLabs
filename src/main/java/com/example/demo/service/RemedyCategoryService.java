package com.example.demo.service;

import com.example.demo.abstractions.BaseCrudService;
import com.example.demo.entity.RemedyCategory;
import com.example.demo.repository.IRemedyCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class RemedyCategoryService extends BaseCrudService<RemedyCategory> {
    public RemedyCategoryService(IRemedyCategoryRepository repository) {
        super(repository);
    }
}
