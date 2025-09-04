package com.luise.ecommer.services.product;

import com.luise.ecommer.entitys.ProductsJpaEntity;
import com.luise.ecommer.model.ProductDto;
import com.luise.ecommer.repository.CategoryRepository;
import com.luise.ecommer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductDto> findAll() {
        if (!productRepository.findAll().isEmpty()) {
            return productRepository.findAll().stream().map(p -> ProductDto.builder()
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
    }

    @Override
    public Optional<ProductsJpaEntity> findById(Long id) {
        return Optional.empty();
    }
}
