package com.luise.ecommer.repository;

import com.luise.ecommer.entitys.CategoryJpaEntity;
import com.luise.ecommer.entitys.ProductsJpaEntity;
import com.luise.ecommer.model.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductsJpaEntity, Long> {

    List<ProductsJpaEntity> findByCatJpaEntity(CategoryJpaEntity categoryJpaEntity);
}
