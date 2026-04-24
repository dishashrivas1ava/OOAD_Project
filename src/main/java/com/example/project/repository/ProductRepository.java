package com.example.project.repository;

import com.example.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; // Add this import!

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

} // The bracket MUST be at the end