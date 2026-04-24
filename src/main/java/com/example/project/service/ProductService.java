package com.example.project.service;

import com.example.project.model.Product;
import com.example.project.model.Transaction;
import com.example.project.repository.ProductRepository;
import com.example.project.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    private static ProductService instance;

    // Private constructor (Singleton rule)
    private ProductService() {}

    // Global access method
    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    @Autowired
    private ProductRepository repo;

    @Autowired 
    private TransactionRepository transactionRepo;

    public List<Product> listAll() { 
        return repo.findAll(); 
    }

    public void save(Product product) { 
        repo.save(product); 
    }

    public void delete(Long id) { 
        repo.deleteById(id); 
    }

    // This method handles the logic of updating stock AND recording the sale
    public void processSale(Long productId, int quantity) {
        Product product = repo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        if (product.getQuantity() >= quantity) {
            // 1. Decrease stock
            product.setQuantity(product.getQuantity() - quantity);
            repo.save(product);

            // 2. Record the transaction
            Transaction t = new Transaction();
            t.setProductName(product.getName());
            t.setQuantitySold(quantity);
            t.setTotalAmount(product.getPrice() * quantity);
            t.setSaleDate(LocalDateTime.now());
            transactionRepo.save(t);
        }
    }
}