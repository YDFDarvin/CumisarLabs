package com.example.demo.entity;

import com.example.demo.interfaces.IBaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Purchase implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pharmacist_id")
    private Pharmacist pharmacist;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "remedy_id")
    private Remedy remedy;
}
