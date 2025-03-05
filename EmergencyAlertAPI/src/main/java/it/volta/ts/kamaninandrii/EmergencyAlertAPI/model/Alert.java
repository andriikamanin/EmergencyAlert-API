package it.volta.ts.kamaninandrii.EmergencyAlertAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Alert implements Serializable {

    @Id
    private String id;               // Уникальный идентификатор уведомления
    private String phoneNumber;      // Номер телефона получателя
    private String message;          // Содержание сообщения
    private String latitude;         // Широта (для добавления в сообщение)
    private String longitude;        // Долгота (для добавления в сообщение)
    private String userId;           // Идентификатор пользователя
    private String status;           // Статус уведомления (например, прочитано, не прочитано)
    private String priority; // Приоритет уведомления
    private String type;   // Тип уведомления (SMS, EMAIL, PUSH и т.д.)
    private long timestamp;          // Время создания уведомления

    // Getters and Setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
