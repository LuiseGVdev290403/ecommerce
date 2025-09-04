package com.luise.ecommer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {
    private Long id;
    private String nameCategory;
}
