package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductCategoryDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.entity.Product;
import org.example.ecommercespring.expection.CategoryNotFoundException;
import org.example.ecommercespring.expection.ProductNotFoundException;
import org.example.ecommercespring.mappers.ProductMapper;
import org.example.ecommercespring.repository.ICategoryRepository;
import org.example.ecommercespring.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;

    public ProductService(IProductRepository productRepository, ICategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        Product product = productRepository.save(ProductMapper.toEntity(productDTO,category));
        return ProductMapper.toDto(product);
    }

    public List<ProductDTO> findExpensiveProduct(double minPrice) {
        return productRepository.findExpensiveProducts(minPrice).stream().map(ProductMapper::toDto).toList();
    }

    public ProductCategoryDTO getProductWithCategory(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
        return ProductMapper.toProductWithCategory(product);
    }

}
