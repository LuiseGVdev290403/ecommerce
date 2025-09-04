package com.luise.ecommer.repository;

import com.luise.ecommer.entitys.CategoryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryJpaEntity, Long> {
}
