package com.rr27.product.service.services;

import com.rr27.product.service.entities.Product;
import com.rr27.dto.service.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rr27.product.service.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id){
        return productRepository.findById(id).get();
    }

    public List<ProductDTO> findAll(){
        return productRepository.findAllBy();
    }
}
