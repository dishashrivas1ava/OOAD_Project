package com.example.project.model;

import jakarta.persistence.*;

@Entity // This tells MySQL: "Create a table for this!"
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;
    
    private String name;
    private double price;
    private int quantity;

    // IMPORTANT: You need Getters and Setters so Spring can read the data
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}