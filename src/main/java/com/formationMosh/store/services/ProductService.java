package com.formationMosh.store.services;

import com.formationMosh.store.dtos.ProductSummaryDto;
import com.formationMosh.store.entities.Category;
import com.formationMosh.store.entities.Product;
import com.formationMosh.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        return productRepository.findAll();
    }

    @Transactional
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Transactional
    public Product updateProduct(Long id, double newPrice) {
        productRepository.updateProductById(id, newPrice);
        return this.getById(id);
    }

    @Transactional
    public void productListByCategory(Category category) {
        List<ProductSummaryDto> products = productRepository.findByCategory(category);
        products.forEach(System.out::println);
    }

    @Transactional
    public void getSortProducts() {
        Sort sort = Sort.by("name").ascending().and(
                Sort.by("price").descending());

        List<Product> products = productRepository.findAll(sort);
        products.forEach(product -> System.out.println(
                product.getCategory().getName() +
                        " : " + product.getName()
                        + " : " + product.getPrice()));
    }

    @Transactional
    public void getPaginateProducts(int pageNumber, int size) {
        PageRequest pageRequest = PageRequest.of(pageNumber, size);

        Page<Product> productPage = productRepository.findAll(pageRequest);

        List<Product> productList = productPage.getContent();

        productList.forEach(product -> System.out.println(product.getName() + " =>" + product.getPrice()));

    }

    @Transactional
    public void getAllProductSortedAndPagine(int pageNumber, int size, String name, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by("name") : Sort.by("name").descending();
        PageRequest pageRequest = PageRequest.of(pageNumber, size, sort);
        Page<Product> productPage = productRepository.findAll(pageRequest);

        List<Product> productList = productPage.getContent();

        productList.forEach(product ->
                System.out.println(product.getId() + " : " + product.getName() + " : " + product.getCategory().getName().toUpperCase()));
    }
}
