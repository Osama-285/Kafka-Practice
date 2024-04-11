package com.study.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.study.kafka.payload.StudentDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {
    // @KafkaListener(topics = "kafkatest", groupId = "myGroup")
    // public void consumeMsg(String msg) {
    // log.info(String.format("Consuming the message from TEST TOPIC :: %s", msg));
    // }
    @KafkaListener(topics = "kafkatest", groupId = "myGroup")
    public void consumeJsonMsg(StudentDTO studentDTO) {
        log.info(String.format("Consuming the message from TEST TOPIC :: %s", studentDTO.toString()));
    }
}
