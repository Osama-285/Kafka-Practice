package com.demo.wikimedia.producer.stream;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.wikimedia.producer.producer.WikimediaProducer;

// import lombok.extern.slf4j.Slf4j; 

@Service
// @Slf4j
public class StreamConsumer {
    private final WebClient webClient;
    private final WikimediaProducer producer;

    public StreamConsumer(WebClient.Builder webClientBuilder, WikimediaProducer producer) {
        this.webClient = webClientBuilder.baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.producer = producer;
    }

    public void consumeStreamAndPublish() {
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessage);
    }

}
