package com.luise.ecommer.controller;

import com.luise.ecommer.services.category.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private ICategoryService iCategoryService;

    public CategoryController(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }
    @GetMapping
    private ResponseEntity<?> getallcategory(){
        return ResponseEntity.ok(iCategoryService.findAll());
    }
    @GetMapping("/{id}")
    private ResponseEntity<?> getproductbycategory(@PathVariable Long id){
        return ResponseEntity.ok(iCategoryService.findProductByCategory(id));
    }
}
