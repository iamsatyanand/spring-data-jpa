package com.satyanand.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends BaseEntity {

    @Column(name = "productName")
    private String name;
    private double price;
    private String description;

    private String productType;
}
