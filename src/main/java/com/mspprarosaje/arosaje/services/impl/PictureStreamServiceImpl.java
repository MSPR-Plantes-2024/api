package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.AppConfig;
import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.services.PictureStreamService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
@NoArgsConstructor
public class PictureStreamServiceImpl implements PictureStreamService {

	@Autowired
	AppConfig appConfig;

	@Override
	public boolean uploadPicture(PictureDTO picture) {
		boolean pictureIsUpload = false;
		try
		{
			byte[] data = picture.getData();
			Files.write(Path.of(appConfig.picturesPath() + picture.getId() +".jpg"), data);
			if (Files.exists(Path.of(appConfig.picturesPath() + picture.getId() +".jpg"))) {
				pictureIsUpload = true;
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return pictureIsUpload;
	}

	@Override
	public byte[] downloadPicture(int pictureId) {
		byte[] pictureData = null;
		try {
			File file = new File(appConfig.picturesPath() + pictureId + ".jpg");
			pictureData = Files.readAllBytes(file.toPath());

		} catch (IOException e) {
			System.out.println(e);
		}
		return pictureData;
	}

	@Override
	public boolean deletePicture(PictureDTO pictureDTO) {
		return new File(appConfig.picturesPath() + pictureDTO.getId() + ".jpg").delete();
	}
}
