package com.satyanand.springdatajpa.controller;

import com.satyanand.springdatajpa.dto.ProductRequestDTO;
import com.satyanand.springdatajpa.dto.ProductResponseDTO;
import com.satyanand.springdatajpa.entity.Product;
import com.satyanand.springdatajpa.service.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO product) {
        return productService.saveProduct(product);
    }

    @GetMapping()
    public List<Product> getAllproducts(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
