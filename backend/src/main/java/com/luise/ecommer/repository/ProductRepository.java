package com.luise.ecommer.repository;

import com.luise.ecommer.entitys.ProductsJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductsJpaEntity, Long> {
}
