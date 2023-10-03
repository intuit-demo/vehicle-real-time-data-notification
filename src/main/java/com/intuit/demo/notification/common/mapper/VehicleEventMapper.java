package com.intuit.demo.notification.common.mapper;

import com.intuit.demo.notification.service.kafka.dto.VehicleCdcEvent;
import com.intuit.demo.notification.service.kafka.dto.VehicleEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleEventMapper {
    VehicleEventMapper INSTANCE = Mappers.getMapper(VehicleEventMapper.class);

    @Mapping(source = "payload.after.id.value", target = "id")
    @Mapping(source = "payload.after.uuid.value", target = "uuid")
    @Mapping(source = "payload.after.registrationNumber.value", target = "registrationNumber")
    @Mapping(source = "payload.after.status.value", target = "status")
    @Mapping(source = "payload.after.latitude.value", target = "latitude")
    @Mapping(source = "payload.after.longitude.value", target = "longitude")
    @Mapping(source = "payload.after.speed.value", target = "speed")
    @Mapping(source = "payload.after.distance.value", target = "distance")
    @Mapping(source = "payload.after.fuel.value", target = "fuel")
    @Mapping(source = "payload.after.eventTs.value", target = "timestamp")
    @Mapping(source = "payload.after.updateTs.value", target = "receivedTimestamp")
    VehicleEvent vehicleCdcToVehicleDto(VehicleCdcEvent vehicleCdcEvent);
}
