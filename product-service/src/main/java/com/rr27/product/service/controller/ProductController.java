package com.rr27.product.service.controller;

import com.rr27.product.service.entities.Product;
import com.rr27.dto.service.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rr27.product.service.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/showAll")
    public List<ProductDTO> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/product")
    public Product getProductById(@RequestParam(name = "id", required = true) Long id){
        return productService.findById(id);
    }
}
