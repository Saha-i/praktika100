package com.example.praktika100.controller;

import com.example.praktika100.model.Product;
import com.example.praktika100.servise.ProductServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductServise productService;

    // Отображение списка товаров
    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";
    }

    // Отображение формы добавления
    @GetMapping("/products/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    // Обработка формы добавления
    @PostMapping("/products/add")
    public String addProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
}
