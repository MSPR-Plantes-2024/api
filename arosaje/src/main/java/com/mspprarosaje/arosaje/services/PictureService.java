package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.model.User;

import java.util.Optional;

public interface PictureService {
    Optional<Picture> getPictureById(Integer id);

}
