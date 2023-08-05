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
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer service_id;

    private String service_name;
    private String service_description;
    private Integer service_price;


    @ManyToMany(mappedBy = "servicess")
    private Set<TuningOrders> tuningOrderses = new LinkedHashSet<>();

}
