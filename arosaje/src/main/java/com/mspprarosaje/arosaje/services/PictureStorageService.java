package com.mspprarosaje.arosaje.services;

import org.springframework.web.multipart.MultipartFile;

public interface PictureStorageService {
    String storePicture(MultipartFile file);
}
