package com.formationMosh.store.repositories;

import com.formationMosh.store.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
