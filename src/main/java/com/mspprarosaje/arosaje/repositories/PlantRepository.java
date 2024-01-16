package com.mspprarosaje.arosaje.repositories;

import com.mspprarosaje.arosaje.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
}
