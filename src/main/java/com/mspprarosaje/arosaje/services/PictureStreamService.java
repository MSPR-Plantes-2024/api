package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;

public interface PictureStreamService {

	/**
	 * Take a picture (byte) and save it in the file system
	 * @param picture picture to save in byte format
	 * @return the path of the saved picture
	 */
	boolean uploadPicture(PictureDTO picture);

	/**
	 * Take a picture id and return the picture data in byte format
	 * @param pictureId id of the picture to download
	 * @return the picture data in byte format
	 */
	byte[] downloadPicture(int pictureId);

	/**
	 * Compress the picture in byte format
	 * @param picture picture to compress in byte format
	 * @return the compressed picture in byte format
	 */
	byte[] compressImage(byte[] picture);

/**
	 * Decompress the picture in byte format
	 * @param picture picture to decompress in byte format
	 * @return the decompressed picture in byte format
	 */
	byte[] decompressImage(byte[] picture);

	/**
	 * Delete a picture from the file system
	 * @param pictureDTO picture to delete
	 * @return true if the picture is deleted, false otherwise
	 */
	boolean deletePicture(PictureDTO pictureDTO);
}
