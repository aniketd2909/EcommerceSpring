package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.expection.CategoryNotFoundException;
import org.example.ecommercespring.mappers.CategoryMapper;
import org.example.ecommercespring.repository.ICategoryRepository;

public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toDto)
                .orElseThrow(() -> new CategoryNotFoundException("Category with ID " + id + " not found"));
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        System.out.println("createCategory");
        Category category = categoryRepository.save(CategoryMapper.toEntity(categoryDTO));
        return CategoryMapper.toDto(category);
    }
}
