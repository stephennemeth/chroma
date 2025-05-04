package com.chroma.backend.services;

import com.chroma.backend.entities.request.ImageUploadRequest;
import com.chroma.backend.kafka.topics.ImageUploadedTopic;
import com.chroma.backend.kafka.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("imageService")
public class ImageService {

    @Autowired
    @Qualifier("imageUploadedTopicService")
    private ImageUploadedTopicService imageUploadedTopicService;

    private void uploadImage(ImageUploadRequest request) {
        Topic topic = new ImageUploadedTopic();
        this.imageUploadedTopicService.sendImageUploadedTopic(topic);
    }
}
