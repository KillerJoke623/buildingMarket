package com.auto.data.repositories;

import com.auto.data.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
//    List<Model> findByManufacturerId(Integer manufacturerId);

}