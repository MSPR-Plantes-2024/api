package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.model.User;

import java.util.List;
import java.util.Optional;

public interface PictureService {
    Optional<Picture> getPictureById(Integer id);

	Picture createPicture(Picture picture);

	Picture updatePicture(Integer id, Picture picture);

    List<Picture> getPictures();

	void deletePicture(int id);
}

