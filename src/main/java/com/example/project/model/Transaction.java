package com.example.project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int quantitySold;
    private double totalAmount;
    private LocalDateTime saleDate;

    // GETTERS AND SETTERS (Copy these exactly)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getQuantitySold() { return quantitySold; }
    public void setQuantitySold(int quantitySold) { this.quantitySold = quantitySold; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public LocalDateTime getSaleDate() { return saleDate; }
    public void setSaleDate(LocalDateTime saleDate) { this.saleDate = saleDate; }
}