package com.intuit.demo.notification.common.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.demo.notification.service.kafka.dto.VehicleOverSpeedEvent;
import org.apache.kafka.common.serialization.Serializer;

public class VehicleEventSerializer implements Serializer<VehicleOverSpeedEvent> {

    private ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Override
    public byte[] serialize(String s, VehicleOverSpeedEvent vehicleOverSpeedEvent) {

        try {
            return objectMapper.writeValueAsBytes(vehicleOverSpeedEvent);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
