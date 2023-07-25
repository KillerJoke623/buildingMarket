package com.auto.data.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CarPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carpart_id;
    private String carpart_name;

    private Integer carpart_price;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "model_car_part_carpart_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "tuning_orders_order_id")
    private TuningOrders tuningOrders;

}
