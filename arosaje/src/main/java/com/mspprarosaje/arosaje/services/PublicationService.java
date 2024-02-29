package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Publication;

import java.util.List;

public interface PublicationService {

	/**
	 * Get all publications
	 * @return
	 */
    List<Publication> getPublications();

	/**
	 * Get publication by id
	 * @param id
	 * @return
	 */
    Publication getPublicationById(int id);

	/**
	 * Save publication
	 * @param publication
	 * @return
	 */
    Publication savePublication(Publication publication);

	/**
	 * Delete publication by id
	 * @param id
	 */
    void deleteById(Integer id);

	/**
	 * Get publications by user id
	 * @param id
	 * @return
	 */
    List<Publication> getPublicationsByUserId(Integer id);
}
