package com.chroma.backend.controllers;

import com.chroma.backend.entities.request.ImageUploadRequest;
import com.chroma.backend.entities.response.ImageUploadResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/images")
public class ImageController {

    @PostMapping("/upload")
    public ResponseEntity<ImageUploadResponse> uploadImage(@RequestBody ImageUploadRequest imageUploadRequest) {
        throw new UnsupportedOperationException();
    }
}
