package com.example.demo.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Category {
    @Id
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
