package com.luise.ecommer.services.category;

import com.luise.ecommer.entitys.CategoryJpaEntity;
import com.luise.ecommer.model.CategoryDto;
import com.luise.ecommer.model.ProductDto;
import com.luise.ecommer.repository.CategoryRepository;
import com.luise.ecommer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CategoryDto> findAll() {
        if (!categoryRepository.findAll().isEmpty()) {
            return categoryRepository.findAll().stream().map(c  -> CategoryDto.builder()
                    .id(c.getId())
                    .nameCategory(c.getNameCategory())
                    .build()).toList();
        } else {
            return List.of();
        }
    }

    @Override
    public List<ProductDto> findProductByCategory(Long id) {
        try {
            CategoryJpaEntity categoryJpaEntity = categoryRepository.findById(id).orElseThrow(RuntimeException::new);
            if (!productRepository.findByCatJpaEntity(categoryJpaEntity).isEmpty() && categoryJpaEntity != null){
                return productRepository.findAll().stream().map((p) -> ProductDto.builder()
                        .productName(p.getProductName())
                        .descriptionLarge(p.getDescriptionLarge())
                        .shortDescription(p.getShortDescription())
                        .precie(p.getPrecie())
                        .imageUrl(p.getImageUrl())
                        .stock(p.getStock())
                        .sku(p.getSku())
                        .id(p.getId())
                        .build()).toList();
            } else {
                return List.of();
            }
        } catch (Exception e) {
            return List.of();
        }
    }
}
