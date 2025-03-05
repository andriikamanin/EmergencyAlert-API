package it.volta.ts.kamaninandrii.EmergencyAlertAPI.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SimpleMessageProducer {

    private static final Logger log = LoggerFactory.getLogger(SimpleMessageProducer.class);

    private final String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SimpleMessageProducer(@Value("${spring-kafka-introduction.topic}") final String topicName,
                                 final KafkaTemplate<String, String> kafkaTemplate) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(final String message) {
        final String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topicName, key, message);
        log.info("Submitted message {} to topic {].", message, topicName);
    }
}
