package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.Publication;
import com.mspprarosaje.arosaje.repositories.PublicationRepository;
import com.mspprarosaje.arosaje.services.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;
    @Override
    public Publication savePublication(Publication publication) {
        return this.publicationRepository.save(publication);
    }
}
