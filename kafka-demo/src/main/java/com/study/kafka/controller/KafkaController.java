package com.study.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.kafka.Producer.KafkaJSONProducer;
import com.study.kafka.Producer.KafkaProducer;
import com.study.kafka.payload.StudentDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJSONProducer kafkaJsonProducer;

    @PostMapping(value = "/test")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message Queued Successfully");
    }

    @PostMapping(value = "/testjson")
    public ResponseEntity<String> sendJsonMessage(@RequestBody StudentDTO message) {
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message Queued Successfully as JSON");
    }

}
