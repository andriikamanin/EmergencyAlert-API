package it.volta.ts.kamaninandrii.EmergencyAlertAPI.kafka;

import it.volta.ts.kamaninandrii.EmergencyAlertAPI.model.Alert;
import it.volta.ts.kamaninandrii.EmergencyAlertAPI.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class SimpleMessageConsumer {

    private static final Logger log = LoggerFactory.getLogger(SimpleMessageConsumer.class);

    private final MessageService messageService;

    @Autowired
    public SimpleMessageConsumer(final MessageService messageService) {
        this.messageService = messageService;
    }

    @KafkaListener(topics = "emergency-notifications", groupId = "notification-group")
    public void listen(final Alert alert) {
        log.info("Received alert: {}.", alert);
        messageService.onMessageReceived(alert);
    }
}