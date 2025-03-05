package it.volta.ts.kamaninandrii.EmergencyAlertAPI.repository;

import it.volta.ts.kamaninandrii.EmergencyAlertAPI.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlertRepository extends JpaRepository<Alert, Long> {
}