package com.mspprarosaje.arosaje.repositories;

import com.mspprarosaje.arosaje.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Integer> {
    //Todo : à modifier en cas de conflit avec le travail d'Alex
}
