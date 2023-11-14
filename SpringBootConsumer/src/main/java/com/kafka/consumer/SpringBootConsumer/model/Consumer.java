package com.kafka.consumer.SpringBootConsumer.model;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = {"twitter-Topic"}, groupId = "my-group-id")
    public void consume(String message){
        logger.info(String.format("#### -> Consumed message -> %s", message));    }
}
