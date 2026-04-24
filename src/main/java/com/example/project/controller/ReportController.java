package com.example.project.controller;

import com.example.project.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/reports")
    public String viewReports(Model model) {
        model.addAttribute("transactions", transactionService.getAllTransactions());
        model.addAttribute("totalRevenue", transactionService.calculateTotalRevenue());
        return "reports";
    }
}