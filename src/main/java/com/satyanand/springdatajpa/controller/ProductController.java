package com.satyanand.springdatajpa.controller;

import com.satyanand.springdatajpa.dto.ProductRequestDTO;
import com.satyanand.springdatajpa.dto.ProductResponseDTO;
import com.satyanand.springdatajpa.entity.Product;
import com.satyanand.springdatajpa.service.IProductService;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<ProductResponseDTO> getAllproducts(){
        return productService.findAll();
    }

    @GetMapping("/sortedByPrice")
    public List<ProductResponseDTO> findAllSortedByPrice(){
        return productService.findAllSortedByPrice();
    }

    @GetMapping("/sort/{sortBy}")
    public List<ProductResponseDTO> findAllProducts(@PathVariable String sortBy ){
        return productService.findAllProducts(sortBy);
    }

    @GetMapping("/sortDesc/{sortBy}")
    public List<ProductResponseDTO> findAllProductsSortedByDesc(@PathVariable String sortBy ){
        return productService.findAllProductsSortedByDesc(sortBy);
    }

    @GetMapping("/pagination")
    public Page<ProductResponseDTO> findAllProductsSortedByDesc(@RequestParam(defaultValue = "1") int pageNumber ){
        return productService.findAllWithPagination(pageNumber);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/search/{name}")
    public List<ProductResponseDTO> findProductByName(@PathVariable String name) {
        return productService.findproductByName(name);
    }

    @GetMapping("/type/{type}")
    public List<ProductResponseDTO> findProductByProductType(@PathVariable String type) {
        return productService.findProductByProductType(type);
    }

    @GetMapping("/price/{price}")
    public List<ProductResponseDTO> getProductByPrice(@PathVariable double price) {
        return productService.getProductByPrice(price);
    }

    @GetMapping("/price/sql/{price}")
    public List<ProductResponseDTO> getProductByPriceViaSQL(@PathVariable double price) {
        return productService.getProductByPriceViaSQL(price);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/price/{price}/type/{productType}")
    public List<ProductResponseDTO> findByPriceAndProductType(@PathVariable double price, @RequestParam String productType) {
        return productService.findByPriceAndProductType(price, productType);
    }

    @PostMapping("/price-in")
    public List<ProductResponseDTO> findByPriceIn(@RequestBody List<Double> prices) {
        return productService.findByPriceIn(prices);
    }

    @GetMapping("/price")
    public List<ProductResponseDTO> findByPriceBetween(@PathVariable double minPrice, @PathVariable double maxPrice) {
        return productService.findByPriceBetween(minPrice, maxPrice);
    }

    @GetMapping("/price-greater-than/{price}")
    public List<ProductResponseDTO> findByPriceGreaterThan(@PathVariable double price) {
        return productService.findByPriceGreaterThan(price);
    }

    @GetMapping("/price-less-than/{price}")
    public List<ProductResponseDTO> findByPriceLessThan(@PathVariable double price) {
        return productService.findByPriceLessThan(price);
    }

    @GetMapping("/name-contains/{name}")
    public List<ProductResponseDTO> findByNameIgnoreCaseContaining(@PathVariable String name) {
        return productService.findByNameIgnoreCaseContaining(name);
    }
}
