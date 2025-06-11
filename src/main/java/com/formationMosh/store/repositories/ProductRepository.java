package com.formationMosh.store.repositories;

import com.formationMosh.store.dtos.ProductSummaryDto;
import com.formationMosh.store.entities.Category;
import com.formationMosh.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query("UPDATE Product p SET p.price = :newPrice WHERE p.id = :idProduct")
    void updateProductById(@Param("idProduct") Long idProduct, @Param("newPrice") double price);

    List<ProductSummaryDto> findByCategory(Category category);
}
