package com.auto.data.models;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer car_id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "manufacturer_manufacturer_id")
    private Manufacturers manufacturer;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "model_car_part_carpart_id")
    private Model model;
}
