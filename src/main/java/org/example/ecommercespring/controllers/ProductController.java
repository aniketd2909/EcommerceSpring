package org.example.ecommercespring.controllers;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.ProductCategoryDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.services.IProductService;
import org.example.ecommercespring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO product = this.productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) throws Exception{
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping
    public ResponseEntity<?> findExpensiveProducts(@RequestParam(required = false) double minPrice) throws IOException {
        List<ProductDTO> productDTOS= productService.findExpensiveProduct(minPrice);
        return ResponseEntity.ok(productDTOS);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ProductCategoryDTO> getProductWithCategory(@PathVariable long id) throws IOException {
        ProductCategoryDTO productCategoryDTO = productService.getProductWithCategory(id);
        return ResponseEntity.ok(productCategoryDTO);
    }

}
