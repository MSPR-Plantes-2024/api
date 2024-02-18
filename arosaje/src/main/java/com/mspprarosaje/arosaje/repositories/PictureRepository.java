package com.mspprarosaje.arosaje.repositories;

import com.mspprarosaje.arosaje.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PictureRepository extends JpaRepository<Picture, Integer>{
	Optional<Picture> findById(Integer id);
}
