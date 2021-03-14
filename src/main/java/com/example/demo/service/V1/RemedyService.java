package com.example.demo.service.V1;

import com.example.demo.entity.Remedy;
import com.example.demo.repository.IRemedyRepository;
import com.example.demo.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class RemedyService extends BaseCrudService<Remedy> {
    public RemedyService(IRemedyRepository repository) {
        super(repository);
    }
}
