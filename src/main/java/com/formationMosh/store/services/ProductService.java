package com.formationMosh.store.services;

import com.formationMosh.store.entities.Product;
import com.formationMosh.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public List<Product> productList() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
