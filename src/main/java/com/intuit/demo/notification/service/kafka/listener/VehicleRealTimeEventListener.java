package com.intuit.demo.notification.service.kafka.listener;

import com.intuit.demo.notification.common.mapper.VehicleEventMapper;
import com.intuit.demo.notification.service.LocationService;
import com.intuit.demo.notification.service.camunda.process.CamundaProcessService;
import com.intuit.demo.notification.service.kafka.dto.VehicleRealTimeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import reactor.util.function.Tuples;

import java.util.UUID;

@Slf4j
@Service
public class VehicleRealTimeEventListener {

    private final CamundaProcessService camundaProcessService;
    private final LocationService<Double, Double> locationService;

    public VehicleRealTimeEventListener(CamundaProcessService camundaProcessService, LocationService<Double, Double> locationService) {
        this.camundaProcessService = camundaProcessService;
        this.locationService = locationService;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(VehicleRealTimeEvent vehicleEvent) {

        log.info("Received message: {}", vehicleEvent);

        var distance = locationService.calculateDistance(Tuples.of(vehicleEvent.getLatitude(), vehicleEvent.getLongitude()),
                Tuples.of(vehicleEvent.getLastKnowGeoLocation().getLatitude(), vehicleEvent.getLastKnowGeoLocation().getLongitude()), vehicleEvent.getSpeed());

        var event = VehicleEventMapper.INSTANCE.vehicleEventToOverSpeedEvent(vehicleEvent);
        event.setDistance(distance);
        event.setId(UUID.randomUUID().toString());

        camundaProcessService.startProcessInstance(event);
    }
}
