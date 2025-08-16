package org.example.ecommercespring.controllers;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<CategoryDTO> getCategory() throws IOException {
        return this.categoryService.getAllCategories();
    }

    @GetMapping("/count")
    public int getCategoryCount(){
        return 3;
    }

}
