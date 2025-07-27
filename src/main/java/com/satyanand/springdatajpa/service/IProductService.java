package com.satyanand.springdatajpa.service;

import com.satyanand.springdatajpa.dto.ProductRequestDTO;
import com.satyanand.springdatajpa.dto.ProductResponseDTO;
import com.satyanand.springdatajpa.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {
    List<ProductResponseDTO> findAll();
    List<ProductResponseDTO> findAllSortedByPrice();
    List<ProductResponseDTO> findAllProducts(String sortBy);
    List<ProductResponseDTO> findAllProductsSortedByDesc(String sortBy);
    Page<ProductResponseDTO> findAllWithPagination(int pageNumber);
    Page<ProductResponseDTO> findProductLikeDescription(String description, int pageNumber);
    Product getProductById(Long id);
    ProductResponseDTO saveProduct(ProductRequestDTO product);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO product);
    void deleteProduct(Long id);
    List<ProductResponseDTO> findproductByName(String name);
    List<ProductResponseDTO> findProductByProductType(String type);
    List<ProductResponseDTO> getProductByPrice(double price);
    List<ProductResponseDTO> getProductByPriceViaSQL(double price);
    List<ProductResponseDTO> findByPriceAndProductType(double price, String productType);
    List<ProductResponseDTO> findByPriceIn(List<Double> prices);
    List<ProductResponseDTO> findByPriceBetween(double minPrice, double maxPrice);
    List<ProductResponseDTO> findByPriceGreaterThan(double price);
    List<ProductResponseDTO> findByPriceLessThan(double price);
    List<ProductResponseDTO> findByNameIgnoreCaseContaining(String name);

}
