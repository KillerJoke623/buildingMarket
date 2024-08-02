package com.auto.data.controllers;

import com.auto.data.models.*;
import com.auto.data.models.Product;
import com.auto.data.repositories.*;
import com.auto.data.services.OrdersService;
import com.auto.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/product/{productId}")
public class OrdersController {
    @Autowired
    private OrdersService tuningOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;


    @PostMapping
    public String createOrder(@ModelAttribute("orders") Orders orders, @ModelAttribute("product") Product product, @ModelAttribute("quantity") Integer quantity) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        orders.setUser(userService.getUserByEmail(userName));
        orders.setDateTime(LocalDateTime.now());

        Product dbProduct = productRepository.findById(product.getProduct_id()).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        dbProduct.setProduct_quantity(dbProduct.getProduct_quantity()-quantity);

        productRepository.save(dbProduct);


        Set<Product> products = new LinkedHashSet<Product>();
        products.add(product);
        orders.setProducts(products);

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);



        Set<OrderItem> items =  new LinkedHashSet<>();
        items.add(orderItem);
        orders.setOrderItems(items);


        tuningOrderService.createTuningOrder(orders);
        orders.getOrder_id();
        orderItem.setOrder(orders);
        orderItemRepository.save(orderItem);



        return "newOrder";
    }

    @GetMapping
    public String showRegistrationForm(Model model, @PathVariable Integer productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Service not found"));
        List<Category> categories = categoryRepository.findAll();

        model.addAttribute("categories", categories);

        model.addAttribute("product", product);
        model.addAttribute("Orders", new Orders());
        return "newOrder";
    }
}
