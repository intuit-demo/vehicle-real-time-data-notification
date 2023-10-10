package com.intuit.demo.notification.service.camunda.servicetask;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.demo.notification.service.kafka.dto.VehicleOverSpeedEvent;
import com.intuit.demo.notification.service.kafka.publisher.OverSpeedKafkaNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("overSpeedNotificationService")
public class OverSpeedNotificationService implements JavaDelegate {

    @Autowired
    private OverSpeedKafkaNotificationService overSpeedKafkaNotificationService;

    private ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("over speed notification fired ...");
        VehicleOverSpeedEvent vehicleOverSpeedEvent = objectMapper.convertValue(delegateExecution.getVariables(), VehicleOverSpeedEvent.class);
        overSpeedKafkaNotificationService.sendEvent(vehicleOverSpeedEvent);
    }
}
