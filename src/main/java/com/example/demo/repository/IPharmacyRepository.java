package com.example.demo.repository;

import com.example.demo.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPharmacyRepository extends JpaRepository<Pharmacy, Long> {
}
