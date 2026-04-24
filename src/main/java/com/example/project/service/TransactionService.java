package com.example.project.service;

import com.example.project.model.Transaction;
import com.example.project.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }
    public double calculateTotalRevenue() {
        return transactionRepo.findAll().stream()
            .mapToDouble(Transaction::getTotalAmount)
            .sum();
    }
}