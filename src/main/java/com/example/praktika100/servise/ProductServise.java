package com.example.praktika100.servise;

import com.example.praktika100.model.Product;
import com.example.praktika100.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServise {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}