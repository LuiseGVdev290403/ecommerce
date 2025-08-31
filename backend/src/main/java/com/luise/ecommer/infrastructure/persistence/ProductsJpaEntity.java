package com.luise.ecommer.infrastructure.persistence;

import com.luise.ecommer.infrastructure.persistence.embeddables.DateAudit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductsJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name", length = 120, nullable = false)
    private String productName;
    @Column(name = "sku", unique = true, length = 250)
    private String sku;
    @Column(name = "precie", nullable = false, precision = 10,scale = 2)
    private BigDecimal precie;
    @Column(name = "image_url", length = 250)
    private String imageUrl;
    @Column(name = "short_description", columnDefinition = "TEXT")
    private String shortDescription;
    @Column(name = "description_large", columnDefinition = "TEXT")
    private String descriptionLarge;
    @Column(name = "stock")
    @Min(value = 1, message = "The stock must be greater than 0")
    private int stock;
    @Embedded
    private DateAudit dateAudit;

    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")

    )
    private Set<CategoryJpaEntity> catJpaEntity = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "product_brand                                                              ",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")

    )
    private Set<BrandJpaEntity> brandJpaEntity = new HashSet<>();
}
