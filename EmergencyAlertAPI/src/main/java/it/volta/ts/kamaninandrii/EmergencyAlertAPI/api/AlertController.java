package it.volta.ts.kamaninandrii.EmergencyAlertAPI.api;

import it.volta.ts.kamaninandrii.EmergencyAlertAPI.model.Alert;
import it.volta.ts.kamaninandrii.EmergencyAlertAPI.service.AlertService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertService alertService;

    @Autowired
    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public ResponseEntity<Alert> createAlert(@Valid @RequestBody Alert alert) {
        Alert createdAlert = alertService.createAlert(alert);
        return ResponseEntity.ok(createdAlert);
    }

    @GetMapping
    public ResponseEntity<Iterable<Alert>> getAllAlerts() {
        Iterable<Alert> alerts = alertService.getAllAlerts();
        return ResponseEntity.ok(alerts);
    }
}