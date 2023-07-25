package com.auto.data.repositories;

import com.auto.data.models.Manufacturers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturersRepository extends JpaRepository<Manufacturers, Integer> {
}