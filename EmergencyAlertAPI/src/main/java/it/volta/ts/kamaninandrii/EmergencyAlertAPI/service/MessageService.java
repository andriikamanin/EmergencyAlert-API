package it.volta.ts.kamaninandrii.EmergencyAlertAPI.service;

import it.volta.ts.kamaninandrii.EmergencyAlertAPI.model.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

    private final List<Alert> receivedAlerts = Collections.synchronizedList(new ArrayList<>());

    public void onMessageReceived(final Alert alert) {
        receivedAlerts.add(alert);
        log.info("Stored alert {} for future reference.", alert);
    }

    public List<Alert> getReceivedAlerts() {
        return Collections.unmodifiableList(new ArrayList<>(receivedAlerts));
    }
}