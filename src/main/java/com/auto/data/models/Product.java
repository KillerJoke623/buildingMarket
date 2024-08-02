package com.auto.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;

    private String product_name;
    private String product_description;
    private Integer product_price;
    private Integer product_quantity;


    @ManyToMany(mappedBy = "products")
    private Set<Orders> orders = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_category_id")
    private Category category;

}
