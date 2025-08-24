package com.vogdo.springmvcthymeleafspringsecurity.repository;

import com.vogdo.springmvcthymeleafspringsecurity.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainingIgnoreCase(String Keyword, Pageable pageable);
}
