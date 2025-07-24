package com.satyanand.springdatajpa.mapper;

import com.satyanand.springdatajpa.dto.ProductRequestDTO;
import com.satyanand.springdatajpa.dto.ProductResponseDTO;
import com.satyanand.springdatajpa.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMappers {

    public static Product toEntity(ProductRequestDTO productDTO){
        return Product.builder()
                .name(productDTO.getProductName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .productType(productDTO.getProductType())
                .build();
    }

    public static ProductResponseDTO toResponseDTO(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .productName(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .productType(product.getProductType())
                .build();
    }

    public static List<ProductResponseDTO> toProductResponseDTOList(List<Product> products) {
        return products.stream()
                .map(ProductMappers::toResponseDTO)
                .toList();
    }
}
