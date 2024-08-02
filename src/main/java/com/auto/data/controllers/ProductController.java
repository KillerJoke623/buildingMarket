package com.auto.data.controllers;

import com.auto.data.models.Category;
import com.auto.data.repositories.CategoryRepository;
import org.springframework.ui.Model;
import com.auto.data.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.auto.data.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "productPage";
    }
}
