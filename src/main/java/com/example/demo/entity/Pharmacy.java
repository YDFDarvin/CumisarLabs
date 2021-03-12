package com.example.demo.entity;

import com.example.demo.interfaces.entity.IBaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Pharmacy implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "pharmacy")
    private Set<Purchase> purchases;
}
