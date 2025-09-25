package org.example.ecommercespring.mappers;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.entity.Category;

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

}
