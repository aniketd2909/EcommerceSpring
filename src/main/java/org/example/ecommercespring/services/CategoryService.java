package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.CategoryProductsDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.expection.CategoryNotFoundException;
import org.example.ecommercespring.mappers.CategoryMapper;
import org.example.ecommercespring.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
        Category category = categoryRepository.save(CategoryMapper.toEntity(categoryDTO));
        return CategoryMapper.toDto(category);
    }

    public CategoryDTO getCategoryByName(String name) {
        return categoryRepository.findByName(name)
                .map(CategoryMapper::toDto)
                .orElseThrow(() -> new CategoryNotFoundException("Category with ID " + name + " not found"));
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryMapper::toDto).toList();
    }

    public CategoryProductsDTO getAllProductsByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category with ID " + categoryId + " not found"));
        return CategoryMapper.toCategoryProducts(category);
    }

}
