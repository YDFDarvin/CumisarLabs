package com.example.demo.repository;

import com.example.demo.entity.RemedyCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedyCategoryRepository extends JpaRepository<RemedyCategory, Long> {
}
