package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    CategoryDTO getCategoryById(Long id);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getAllCategories() throws IOException;
    CategoryDTO getCategoryByName(String name);

}
