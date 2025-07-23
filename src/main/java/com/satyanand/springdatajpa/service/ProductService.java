package com.satyanand.springdatajpa.service;

import com.satyanand.springdatajpa.dto.ProductRequestDTO;
import com.satyanand.springdatajpa.dto.ProductResponseDTO;
import com.satyanand.springdatajpa.entity.Product;
import com.satyanand.springdatajpa.mapper.ProductMappers;
import com.satyanand.springdatajpa.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO) {

        Product product = productRepository.save(ProductMappers.toEntity(productRequestDTO));
        return ProductMappers.toResponseDTO(product);
    }
}
