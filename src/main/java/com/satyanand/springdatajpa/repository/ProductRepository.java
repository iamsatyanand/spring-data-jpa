package com.satyanand.springdatajpa.repository;

import com.satyanand.springdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    List<Product> findByProductType(String productType);

    List<Product> findByPriceAndProductType(double price, String productType);

    List<Product> findByPriceIn(List<Double> prices);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByPriceLessThan(double price);

    List<Product> findByNameIgnoreCaseContaining(String name);

    @Query("SELECT p FROM Product p WHERE p.price = ?1 ")
    List<Product> getProductByPrice(double price);

    @Query(value = "SELECT * FROM PRODUCT WHERE PRICE = ?1", nativeQuery = true)
    List<Product> getProductByPriceViaSQL(double price);
}
