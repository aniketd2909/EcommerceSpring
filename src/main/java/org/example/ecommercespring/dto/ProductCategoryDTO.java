package org.example.ecommercespring.dto;

import lombok.*;
import org.example.ecommercespring.entity.Category;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDTO {

    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private Long id;
    private String title;
    private Long categoryId;
    private String brand;
    private boolean popular;
    private CategoryDTO categoryDTO;

}
