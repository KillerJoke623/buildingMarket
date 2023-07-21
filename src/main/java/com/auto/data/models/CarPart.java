package com.auto.data.models;

import jakarta.persistence.*;

@Entity
public class СarPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carpart_id;
    private String carpart_name;
    @OneToOne(mappedBy = "model_id")
    private Model model;

    private Integer carpart_price;
}
