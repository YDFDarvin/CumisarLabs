package com.example.demo.repository;

import com.example.demo.entity.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPharmacistRepository extends JpaRepository<Pharmacist, Long> {
}
