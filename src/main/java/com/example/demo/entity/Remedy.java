package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Entity
public class Remedy {
    @Id
    private Long id;

    private String name;
    private BigDecimal price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private RemedyCategory category;
}
