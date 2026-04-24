package com.example.project.controller;

import com.example.project.model.Product;
import com.example.project.model.Transaction; // Add this
import com.example.project.service.ProductService;
import com.example.project.service.TransactionService; // Add this
import com.example.project.repository.ProductRepository; // Add this
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List; // Add this

@Controller
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ProductRepository repo;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listProducts", service.listAll());
        return "index"; // This tells Spring to look for index.html
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<Product> list = repo.findByNameContainingIgnoreCase(keyword); // Assuming repo is autowired
        model.addAttribute("listProducts", list);
    return "index";
}

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/"; // Go back to the home page after saving
    }
    @PostMapping("/sell")
public String sellItem(@RequestParam Long productId, @RequestParam int quantity, Model model) {
    service.processSale(productId, quantity);
    return "redirect:/receipt"; 
}

@GetMapping("/receipt")
public String showReceipt(Model model) {
    List<Transaction> all = transactionService.getAllTransactions();
    Transaction lastSale = all.get(all.size() - 1); // Get the very last sale made
    model.addAttribute("sale", lastSale);
    return "receipt";
}

    
}

