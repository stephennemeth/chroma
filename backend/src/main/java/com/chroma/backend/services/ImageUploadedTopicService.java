package com.chroma.backend.services;

import com.chroma.backend.kafka.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service("imageUploadedTopicService")
public class ImageUploadedTopicService {

    private final String IMAGE_UPLOADED_TOPIC = "image-uploaded";

    @Autowired
    @Qualifier("kafkaTemplate")
    private KafkaTemplate<String, Topic> kafkaTemplate;

    public void sendImageUploadedTopic(Topic topic) {
        this.kafkaTemplate.send(this.IMAGE_UPLOADED_TOPIC, topic);
    }
}
