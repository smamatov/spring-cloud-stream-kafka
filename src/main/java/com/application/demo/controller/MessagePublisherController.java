package com.application.demo.controller;

import com.application.demo.IncomingMessage;
import com.application.demo.configuration.KafkaConfiguration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagePublisherController {


    private KafkaTemplate kafkaTemplate;
    private KafkaConfiguration kafkaConfiguration;

    public MessagePublisherController(KafkaTemplate kafkaTemplate, KafkaConfiguration kafkaConfiguration) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfiguration = kafkaConfiguration;
    }

    @PostMapping("publishMessage")
    public IncomingMessage publishMessageToKafka(@RequestBody IncomingMessage incomingMessage) {
                kafkaTemplate.send( kafkaConfiguration.getKafkaTopicName(),new GenericMessage<>( incomingMessage));
        return incomingMessage;
    }
}
