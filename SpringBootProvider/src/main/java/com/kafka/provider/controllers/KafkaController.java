package com.kafka.provider.controllers;

import com.kafka.provider.model.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final Producer producer;
    @Autowired
    KafkaController(Producer producer){
        this.producer = producer;
    }
    @PostMapping(value = "/tweetear")
    public void sendMessageToKafkaTopic(@RequestParam("tweet") String tweet){
        this.producer.sendMessage(tweet);
    }
}
