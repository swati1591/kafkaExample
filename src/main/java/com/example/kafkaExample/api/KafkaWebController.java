package com.example.kafkaExample.api;

import com.example.kafkaExample.kafkaService.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/kafka")
public class KafkaWebController {

    private final KafkaProducer kafkaProducer;
    @Autowired
    public KafkaWebController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping(value = "send")
    public String producer(@RequestParam("message") String message) {
        kafkaProducer.send(message);
        return "Message sent to Kafka successfully";
    }
}