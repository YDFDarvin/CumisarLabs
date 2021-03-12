package com.example.demo.entity;

import com.example.demo.interfaces.entity.IBaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class RemedyCategory implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<Remedy> remedies;
}
