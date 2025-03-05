package it.volta.ts.kamaninandrii.EmergencyAlertAPI.service;

import it.volta.ts.kamaninandrii.EmergencyAlertAPI.model.Alert;
import it.volta.ts.kamaninandrii.EmergencyAlertAPI.repository.AlertRepository;
import it.volta.ts.kamaninandrii.EmergencyAlertAPI.kafka.SimpleMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlertService {

    private final AlertRepository alertRepository;
    private final SimpleMessageProducer messageProducer;

    @Autowired
    public AlertService(AlertRepository alertRepository, SimpleMessageProducer messageProducer) {
        this.alertRepository = alertRepository;
        this.messageProducer = messageProducer;
    }

    // Метод для создания нового оповещения
    public Alert createAlert(Alert alert) {
        // Генерация уникального ID для оповещения
        String id = UUID.randomUUID().toString();
        alert.setId(id);
        alert.setStatus("Ожидает");

        // Сохраняем оповещение в базе данных
        Alert savedAlert = alertRepository.save(alert);

        // Отправка оповещения в Kafka
        try {
            messageProducer.sendMessage(savedAlert); // ✅ Исправлено: передаем объект Alert
        } catch (Exception e) {
            // Логирование ошибки при отправке в Kafka
            e.printStackTrace();
        }

        return savedAlert;
    }

    // Метод для получения всех оповещений
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    // Метод для обработки оповещений, полученных из Kafka
    public void processAlertFromKafka(Alert alert) {
        // Обработка оповещения после его получения из Kafka
        alert.setStatus("Обработано");
        alertRepository.save(alert);
    }
}