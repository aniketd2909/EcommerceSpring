package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductService {

    ProductDTO getProductById(Long id);

}
