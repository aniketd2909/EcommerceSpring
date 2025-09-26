package org.example.ecommercespring.mappers;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.CategoryProductsDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.entity.Category;

import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryDTO toDto(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO categoryDTO){
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }

    public static CategoryProductsDTO toCategoryProducts(Category category){
        return CategoryProductsDTO.builder()
                .name(category.getName())
                .productDTO(category.getProducts().stream().map(ProductMapper::toDto).toList())
                .build();
    }


}
