package com.luise.ecommer.model;


import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
public class ProductDto {
    private Long id;
    private String productName;
    private String sku;
    private BigDecimal precie;
    private String imageUrl;
    private String shortDescription;
    private String descriptionLarge;
    @Min(value = 1, message = "The stock must be greater than 0")
    private int stock;
}
