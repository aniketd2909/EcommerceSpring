package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> getAllCategories() throws IOException;
}
