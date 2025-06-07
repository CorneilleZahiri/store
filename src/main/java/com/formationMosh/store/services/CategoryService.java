package com.formationMosh.store.services;

import com.formationMosh.store.entities.Category;
import com.formationMosh.store.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

}
