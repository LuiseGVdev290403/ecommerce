package com.luise.ecommer.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class CategoryJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name", nullable = false)
    @Size(min = 5, max = 120, message = "el nombre debera ser mayor a 120 y minimo de 5")
    private String  nameCategory;

    @ManyToMany(mappedBy = "catJpaEntity")
    private Set<ProductsJpaEntity> productsJpaEntities = new HashSet<>();
}
