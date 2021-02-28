package com.example.demo.service;

import com.example.demo.entity.RemedyCategory;
import com.example.demo.repository.RemedyCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class RemedyCategoryService extends BaseCrudService<RemedyCategory> {
    public RemedyCategoryService(RemedyCategoryRepository repository) {
        super(repository);
    }
}
