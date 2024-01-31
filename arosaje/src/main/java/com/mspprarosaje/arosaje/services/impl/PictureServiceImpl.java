package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.services.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Picture> getPictureById(Integer id) {
        return Optional.empty();
    }
}
