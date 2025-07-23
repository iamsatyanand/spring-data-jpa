package com.satyanand.springdatajpa.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {

    private Long id;
    private String productName;
    private Double price;
    private String description;
    private String productType;
}
