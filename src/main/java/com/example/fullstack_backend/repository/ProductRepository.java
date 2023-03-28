package com.example.fullstack_backend.repository;

import com.example.fullstack_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
