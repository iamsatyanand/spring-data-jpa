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
    public List<ProductResponseDTO> findAll() {
        return ProductMappers.toProductResponseDTOList(productRepository.findAll());
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

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO product) {
        Product existingproduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existingproduct.setName(product.getProductName());
        existingproduct.setDescription(product.getDescription());
        existingproduct.setPrice(product.getPrice());
        existingproduct.setProductType(product.getProductType());
        Product updatedProduct = productRepository.save(existingproduct);
        return ProductMappers.toResponseDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);

    }

    @Override
    public List<ProductResponseDTO> findproductByName(String name) {
        return ProductMappers.toProductResponseDTOList(productRepository.findByName(name));
    }

    @Override
    public List<ProductResponseDTO> findProductByProductType(String type) {
        return ProductMappers.toProductResponseDTOList(productRepository.findByProductType(type));
    }

    @Override
    public List<ProductResponseDTO> getProductByPrice(double price) {
        return ProductMappers.toProductResponseDTOList(productRepository.getProductByPrice(price));
    }

    @Override
    public List<ProductResponseDTO> getProductByPriceViaSQL(double price) {
        return ProductMappers.toProductResponseDTOList(productRepository.getProductByPriceViaSQL(price));
    }

    @Override
    public List<ProductResponseDTO> findByPriceAndProductType(double price, String productType) {
        List<Product> products = productRepository.findByPriceAndProductType(price, productType);
        if (products.isEmpty()) {
            throw new RuntimeException("No products found with price: " + price + " and type: " + productType);
        }
        return ProductMappers.toProductResponseDTOList(products);
    }

    @Override
    public List<ProductResponseDTO> findByPriceIn(List<Double> prices) {
        List<Product> products = productRepository.findByPriceIn(prices);
        if(products.isEmpty()){
            throw new RuntimeException("No products found with prices: " + prices);
        } else {
            return ProductMappers.toProductResponseDTOList(products);
        }
    }

    @Override
    public List<ProductResponseDTO> findByPriceBetween(double minPrice, double maxPrice) {
        List<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice);
        if(products.isEmpty()){
            throw new RuntimeException("No products found between prices: " + minPrice + " and " + maxPrice);
        } else {
            return ProductMappers.toProductResponseDTOList(products);
        }
    }

    @Override
    public List<ProductResponseDTO> findByPriceGreaterThan(double price) {
        List<Product> products = productRepository.findByPriceGreaterThan(price);
        if(products.isEmpty()){
            throw new RuntimeException("No products found with price greater than: " + price);
        } else {
            return ProductMappers.toProductResponseDTOList(products);
        }
    }

    @Override
    public List<ProductResponseDTO> findByPriceLessThan(double price) {
        List<Product> products = productRepository.findByPriceLessThan(price);
        if(products.isEmpty()){
            throw new RuntimeException("No products found with price less than: " + price);
        } else {
            return ProductMappers.toProductResponseDTOList(products);
        }
    }

    @Override
    public List<ProductResponseDTO> findByNameIgnoreCaseContaining(String name) {
        List<Product> products = productRepository.findByNameIgnoreCaseContaining(name);
        if(products.isEmpty()){
            throw new RuntimeException("No products found containing name: " + name);
        } else {
            return ProductMappers.toProductResponseDTOList(products);
        }
    }


}
