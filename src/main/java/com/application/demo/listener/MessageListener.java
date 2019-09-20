package com.application.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageListener {

    @KafkaListener(id = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.consumer.destination}", containerFactory = "kafkaContainerFactory")
    public void messageListener(Message<?> message){

        log.info("Incoming message from Kafka ", message);
        // curl -i -X POST -H "Content-Type:application/json" -d "{ "\messageId"\" : \"123\" , \"messageBody\": \"Hello World\"}" http://localhost:8080/postMessage
    }
}
