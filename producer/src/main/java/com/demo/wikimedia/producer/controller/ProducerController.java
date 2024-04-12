package com.demo.wikimedia.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.wikimedia.producer.stream.StreamConsumer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/wikimedia")
@RequiredArgsConstructor
public class ProducerController {
    private final StreamConsumer streamConsumer;

    @GetMapping
    public void publishing() {
        streamConsumer.consumeStreamAndPublish();
    }

}
