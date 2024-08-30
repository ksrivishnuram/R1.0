package com.re5lect.layoffs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "news-topic";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(String message){
        kafkaTemplate.send(TOPIC, message);
        System.out.println("send message: "+message+"to topic: "+ TOPIC);
    }
}
