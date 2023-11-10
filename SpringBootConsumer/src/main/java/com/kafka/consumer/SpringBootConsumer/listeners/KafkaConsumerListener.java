package com.kafka.consumer.SpringBootConsumer.listeners;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {
    private Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = {"twitter-Topic"}, groupId = "my-group-id")
    public void listener(String message){
        LOGGER.info("Mensaje recibido, el mensaje es " + message);
    }
}
