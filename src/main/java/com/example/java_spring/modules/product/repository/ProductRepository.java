package com.example.java_spring.modules.product.repository;

import com.example.java_spring.common.generic.BaseRepository;
import com.example.java_spring.modules.product.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
    // Các method tìm kiếm đặc thù nếu có
}