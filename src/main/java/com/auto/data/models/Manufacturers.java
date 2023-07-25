package com.auto.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Manufacturers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer manufacturer_id;
    private String manufacturer;

    @OneToMany(mappedBy = "manufacturer", orphanRemoval = true)
    private List<Model> models = new ArrayList<>();



}
