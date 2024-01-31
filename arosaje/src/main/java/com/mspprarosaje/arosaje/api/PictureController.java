package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.mappers.PictureMapper;
import com.mspprarosaje.arosaje.services.PictureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pictures")
@RequiredArgsConstructor
@Slf4j
public class PictureController {

    private final PictureService pictureService;
    private final PictureMapper pictureMapper;
}
