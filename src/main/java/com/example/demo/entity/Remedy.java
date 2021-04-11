package com.example.demo.entity;

import com.example.demo.interfaces.IBaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Remedy implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private BigDecimal price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private RemedyCategory category;

    @JsonIgnore
    @OneToMany(mappedBy = "remedy")
    private List<Purchase> purchases;
}
