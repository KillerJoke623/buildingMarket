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
    @JoinColumn(name = "model_car_part_carpart_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "users_user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "manufacturers_manufacturer_id")
    private Manufacturers manufacturers;

}
