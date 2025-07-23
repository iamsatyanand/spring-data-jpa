package com.satyanand.springdatajpa.repository;

import com.satyanand.springdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
