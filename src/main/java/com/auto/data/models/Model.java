package com.auto.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cars {
    @Id
    private Long car_id;
    private String manufacturer_id;
    private Integer generation;

}
