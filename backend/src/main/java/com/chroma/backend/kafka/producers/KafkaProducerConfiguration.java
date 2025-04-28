package com.chroma.backend.kafka.producers;


import com.chroma.backend.kafka.topics.Topic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration("kafkaProducerConfiguration")
public class KafkaProducerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String serverAddress;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Bean("kafkaProducerMap")
    public ProducerFactory<String, Topic> kafkaProducerFactory() {
        Map<String, Object> producerConfigMap = new HashMap<String, Object>();

        producerConfigMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverAddress);
        producerConfigMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerConfigMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<String, Topic>(producerConfigMap);
    }

    @Bean("kafkaTemplate")
    public KafkaTemplate<String, Topic> kafkaTemplate() {
        return new KafkaTemplate<String, Topic>(this.kafkaProducerFactory());
    }
}
