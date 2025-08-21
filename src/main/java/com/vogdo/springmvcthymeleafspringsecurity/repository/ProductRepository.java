package com.vogdo.springmvcthymeleafspringsecurity.repository;

import com.vogdo.springmvcthymeleafspringsecurity.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
