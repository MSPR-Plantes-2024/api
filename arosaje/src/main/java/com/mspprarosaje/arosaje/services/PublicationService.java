package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Publication;

import java.util.List;

public interface PublicationService {
    List<Publication> getPublications();
    Publication getPublicationById(int id);
    Publication savePublication(Publication publication);
    void deleteById(Integer id);
    List<Publication> getPublicationsByUserId(Integer id);
}
