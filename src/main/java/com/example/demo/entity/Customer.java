package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Customer {
    @Id
    private Long id;

    private String name;
    private Double balance;

    @OneToMany(mappedBy = "customer")
    private Set<Purchase> purchases;
}
