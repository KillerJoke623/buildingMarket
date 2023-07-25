package com.auto.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TuningOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    @ManyToOne
    @JoinColumn(name = "users_user_id")
    private Users user;

    private String comment;
    @ManyToOne
    @JoinColumn(name = "car_car_id")
    private Car car;



    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "tuningOrders", orphanRemoval = true)
    private List<Service> services = new ArrayList<>();

    @OneToMany(mappedBy = "tuningOrders", orphanRemoval = true)
    private List<CarPart> carParts = new ArrayList<>();


}
