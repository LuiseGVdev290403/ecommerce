package com.luise.ecommer.services.category;

import com.luise.ecommer.model.CategoryDto;
import com.luise.ecommer.model.ProductDto;

import java.util.List;

public interface ICategoryService {
    List<CategoryDto> findAll();
    List<ProductDto> findProductByCategory(Long id);
}
