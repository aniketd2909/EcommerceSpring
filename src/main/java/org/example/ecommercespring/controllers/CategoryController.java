package org.example.ecommercespring.controllers;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.CategoryProductsDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.services.ICategoryService;
import org.example.ecommercespring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws IOException {
        if(name != null && !name.isEmpty()) {
            CategoryDTO categoryDTO = categoryService.getCategoryByName(name);
            return ResponseEntity.ok(categoryDTO);
        }
        List<CategoryDTO> categoryDTOs= categoryService.getAllCategories();
        return ResponseEntity.ok(categoryDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        CategoryDTO categoryDTO= categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDTO);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws Exception {
        return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<CategoryProductsDTO> getAllProductsByCategoryId(@PathVariable Long id) throws IOException {
        return ResponseEntity.ok(categoryService.getAllProductsByCategoryId(id));
    }
}
