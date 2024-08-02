package com.auto.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    @ManyToOne
    @JoinColumn(name = "users_user_id")
    private Users user;

    private String comment;




    private LocalDateTime dateTime;
    private String status;


    @ManyToMany
    @JoinTable(name = "Orders_products",
            joinColumns = @JoinColumn(name = "tuningOrders_order_id"),
            inverseJoinColumns = @JoinColumn(name = "products_product_id"))
    private Set<Product> products = new LinkedHashSet<>();

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private Set<OrderItem> orderItems = new LinkedHashSet<>();

}
