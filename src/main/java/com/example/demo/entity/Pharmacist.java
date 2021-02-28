package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Pharmacist {
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "pharmacist")
    private Set<Purchase> purchases;
}
