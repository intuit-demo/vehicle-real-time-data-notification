package com.intuit.demo.notification.common.deserializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.demo.notification.common.mapper.VehicleEventMapper;
import com.intuit.demo.notification.service.kafka.dto.VehicleCdcEvent;
import com.intuit.demo.notification.service.kafka.dto.VehicleEvent;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;

public class VehicleCdcEventDeserializer implements Deserializer<VehicleEvent> {

    private ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @SneakyThrows
    @Override
    public VehicleEvent deserialize(String s, byte[] bytes) {
        var e = objectMapper.readValue(bytes, VehicleCdcEvent.class);
        return VehicleEventMapper.INSTANCE.vehicleCdcToVehicleDto(e);
    }
}
