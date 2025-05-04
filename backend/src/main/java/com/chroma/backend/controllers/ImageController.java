package com.chroma.backend.controllers;

import com.chroma.backend.entities.request.ImageUploadRequest;
import com.chroma.backend.entities.response.ImageUploadResponse;
import com.chroma.backend.entities.response.Response;
import com.chroma.backend.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/images")
public class ImageController {

    @Autowired
    @Qualifier("imageService")
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Response> uploadImage(@RequestBody ImageUploadRequest imageUploadRequest) {
        return ResponseEntity.ok(new ImageUploadResponse("Image was uploaded successfully"));
    }
}
