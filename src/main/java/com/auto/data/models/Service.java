package com.auto.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer service_id;

    private String service_name;
    private String service_description;
    private Integer service_price;

    @ManyToOne
    @JoinColumn(name = "tuning_orders_order_id")
    private TuningOrders tuningOrders;
}
