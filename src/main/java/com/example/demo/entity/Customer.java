package com.example.demo.entity;

import com.example.demo.interfaces.IBaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Double balance;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases;
}
