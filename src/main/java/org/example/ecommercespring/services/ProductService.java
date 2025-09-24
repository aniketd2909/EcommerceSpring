package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.entity.Product;
import org.example.ecommercespring.expection.ProductNotFoundException;
import org.example.ecommercespring.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
        return new ProductDTO();
    }

}
