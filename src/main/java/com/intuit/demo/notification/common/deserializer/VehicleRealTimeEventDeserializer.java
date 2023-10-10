package com.intuit.demo.notification.common.deserializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.demo.notification.service.kafka.dto.VehicleRealTimeEvent;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;

public class VehicleRealTimeEventDeserializer implements Deserializer<VehicleRealTimeEvent> {

    private ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @SneakyThrows
    @Override
    public VehicleRealTimeEvent deserialize(String s, byte[] bytes) {
        return objectMapper.readValue(bytes, VehicleRealTimeEvent.class);
    }
}
