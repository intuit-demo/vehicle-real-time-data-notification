package com.intuit.demo.notification.service.camunda.process;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.demo.notification.service.kafka.dto.VehicleOverSpeedEvent;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service("camundaProcessService")
public class CamundaProcessService {

    @Autowired
    private RuntimeService runtimeService;

    private ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public void startProcessInstance(VehicleOverSpeedEvent vehicleEvent) {
        Map variables = objectMapper.convertValue(vehicleEvent, Map.class);
        var p = runtimeService.startProcessInstanceByKey("vehicleTrackingWorkflow", variables);

        log.info("Started process instance with ID: {}", p.getId());
    }
}