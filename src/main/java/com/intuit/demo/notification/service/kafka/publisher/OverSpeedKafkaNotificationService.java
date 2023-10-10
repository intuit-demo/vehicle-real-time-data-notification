package com.intuit.demo.notification.service.kafka.publisher;

import com.intuit.demo.notification.service.kafka.dto.VehicleOverSpeedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OverSpeedKafkaNotificationService {

    @Value("${spring.kafka.producer.topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, VehicleOverSpeedEvent> kafkaTemplate;

    public void sendEvent(VehicleOverSpeedEvent message) {
        kafkaTemplate.send(topicName, message);
    }
}
