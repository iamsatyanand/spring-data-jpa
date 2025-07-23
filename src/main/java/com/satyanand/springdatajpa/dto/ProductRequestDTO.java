package com.satyanand.springdatajpa.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDTO {
    @NotBlank
    private String productName;

    @Min(value = 0, message = "Price must be non-negative")
    private Double price;

    @NotBlank
    private String description;

    @NotBlank
    private String productType;
}
