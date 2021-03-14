package com.example.demo.service.V1;

import com.example.demo.entity.RemedyCategory;
import com.example.demo.repository.IRemedyCategoryRepository;
import com.example.demo.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class RemedyCategoryService extends BaseCrudService<RemedyCategory> {
    public RemedyCategoryService(IRemedyCategoryRepository repository) {
        super(repository);
    }
}
