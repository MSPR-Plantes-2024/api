package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.services.PictureService;
import com.mspprarosaje.arosaje.repositories.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {

	final PictureRepository pictureRepository;

    @Override
    public Optional<Picture> getPictureById(Integer id) {
        return this.pictureRepository.findById(id);
    }

	@Override
	public Picture createPicture(Picture picture) {
		return this.pictureRepository.save(picture);
	}

	@Override
	public Picture updatePicture(Integer id, Picture picture) {
		return this.pictureRepository.save(picture);
	}

	@Override
	public List<Picture> getPictures() {
		return this.pictureRepository.findAll();
	}

	/**
	 * @param id
	 */
	@Override
	public void deletePicture(int id) {this.pictureRepository.deleteById(id);}
}
