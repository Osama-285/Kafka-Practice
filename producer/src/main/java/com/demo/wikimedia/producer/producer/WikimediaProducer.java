package com.demo.wikimedia.producer.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
// @Slf4j
public class WikimediaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("wikimwdia-stream", msg);
    }
}
