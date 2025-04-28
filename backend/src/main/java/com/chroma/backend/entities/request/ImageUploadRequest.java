package com.chroma.backend.entities.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.UUID;

public class ImageUploadRequest {

    @JsonProperty("image")
    private MultipartFile image;

    @JsonProperty("dateTime")
    private Date dateTime;

    @JsonProperty("userId")
    private UUID userId;
}
