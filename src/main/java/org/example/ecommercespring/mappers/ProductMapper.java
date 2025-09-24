package org.example.ecommercespring.mappers;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.entity.Product;

public class ProductMapper {

    public static ProductDTO toDto(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .category(product.getCategory())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

}
