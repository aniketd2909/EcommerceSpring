package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductCategoryDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductService {

    ProductDTO getProductById(Long id);
    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> findExpensiveProduct(double minPrice);
    ProductCategoryDTO getProductWithCategory(long id);
}
