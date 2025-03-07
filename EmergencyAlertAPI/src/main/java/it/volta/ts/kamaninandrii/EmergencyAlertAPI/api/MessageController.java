package it.volta.ts.kamaninandrii.EmergencyAlertAPI.api;

import it.volta.ts.kamaninandrii.EmergencyAlertAPI.kafka.SimpleMessageProducer;
import it.volta.ts.kamaninandrii.EmergencyAlertAPI.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    private final SimpleMessageProducer producer;

    private final MessageService messageService;

    @Autowired
    public MessageController(final SimpleMessageProducer producer, final MessageService messageService) {
        this.producer = producer;
        this.messageService = messageService;
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> submitMessage(@RequestBody String message) {
        log.info("Accepted message {}, attempting to submit it to Kafka.", message);
        producer.sendMessage(message);
        return ResponseEntity.accepted().build();
    }*/

    /*@RequestMapping(method = RequestMethod.GET)
    public Collection<String> listReceivedMessages() {
        return messageService.getReceivedMessages();
    }*/
}
