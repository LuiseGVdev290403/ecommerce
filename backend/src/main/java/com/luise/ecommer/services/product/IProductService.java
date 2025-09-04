package com.luise.ecommer.services.product;

import com.luise.ecommer.entitys.ProductsJpaEntity;
import com.luise.ecommer.model.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductDto> findAll();
    Optional<ProductsJpaEntity> findById(Long id);
}
