package com.luise.ecommer.controller;


import com.luise.ecommer.services.product.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<?> getProducts(){
        return ResponseEntity.ok(productService.findAll());
    }


}
