package com.satyanand.springdatajpa.service;

import com.satyanand.springdatajpa.dto.ProductRequestDTO;
import com.satyanand.springdatajpa.dto.ProductResponseDTO;
import com.satyanand.springdatajpa.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product getProductById(Long id);
    ProductResponseDTO saveProduct(ProductRequestDTO product);
}
