package com.mspprarosaje.arosaje.repositories;

import com.mspprarosaje.arosaje.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
    List<Plant> findByUserId(Integer userId);
    List<Plant> findByAddressId(Integer addressId);
}
