package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.Publication;
import com.mspprarosaje.arosaje.repositories.PublicationRepository;
import com.mspprarosaje.arosaje.services.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;

    @Override
    public List<Publication> getPublications() {
        return this.publicationRepository.findAll();
    }

    @Override
    public Publication getPublicationById(int id) {
        return this.publicationRepository.findById(id).orElse(null);
    }

    @Override
    public Publication savePublication(Publication publication) {
        return this.publicationRepository.save(publication);
    }

    @Override
    public void deleteById(Integer id) { this.publicationRepository.deleteById(id);}
}
