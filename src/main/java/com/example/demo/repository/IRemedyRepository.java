package com.example.demo.repository;

import com.example.demo.entity.Remedy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRemedyRepository extends JpaRepository<Remedy, Long> {
}
