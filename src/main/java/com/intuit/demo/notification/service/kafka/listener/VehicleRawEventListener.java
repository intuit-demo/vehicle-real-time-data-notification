package com.intuit.demo.notification.service.kafka.listener;

import com.intuit.demo.notification.service.kafka.dto.VehicleCdcEvent;
import com.intuit.demo.notification.service.kafka.dto.VehicleEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VehicleRawEventListener {

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(VehicleEvent message) {
        System.out.println("Received message: " + message);
    }
}
