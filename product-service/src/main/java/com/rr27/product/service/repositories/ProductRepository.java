package com.rr27.product.service.repositories;

import com.rr27.product.service.entities.Product;
import com.rr27.dto.service.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findOneById(Long id);       //TODO тоже возвращать DTO
    List<ProductDTO> findAllBy();
}
