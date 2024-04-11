package com.study.kafka.Producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.study.kafka.payload.StudentDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaJSONProducer {

    private final KafkaTemplate<String, StudentDTO> kafkaTemplate;

    public void sendMessage(StudentDTO studentDTO) {
        Message<StudentDTO> message = MessageBuilder.withPayload(studentDTO).setHeader(KafkaHeaders.TOPIC, "kafkatest")
                .build();
        kafkaTemplate.send(message);
    }
}
