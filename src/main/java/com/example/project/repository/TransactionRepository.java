package com.example.project.repository;

import com.example.project.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}