package com.mspprarosaje.arosaje.repositories;

import com.mspprarosaje.arosaje.model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {
	List<Publication> findByPublisherId(Integer userId);
}
