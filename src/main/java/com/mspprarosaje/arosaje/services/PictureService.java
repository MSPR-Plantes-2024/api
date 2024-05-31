package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.model.User;

import java.util.List;
import java.util.Optional;

public interface PictureService {

	/**
	 * Get picture by id
 	 * @param id
	 * @return
	 */
    Optional<Picture> getPictureById(Integer id);

	/**
	 * Create picture
	 * @param picture
	 * @return
	 */
	Picture createPicture(Picture picture);

	/**
	 * Update picture
	 * @param id
	 * @param picture
	 * @return
	 */
	Picture updatePicture(Integer id, Picture picture);


	/**
	 * Get all pictures
	 * @return
	 */
    List<Picture> getPictures();


	/**
	 * Delete picture by id
	 * @param id
	 */
	void deletePicture(int id);
}

