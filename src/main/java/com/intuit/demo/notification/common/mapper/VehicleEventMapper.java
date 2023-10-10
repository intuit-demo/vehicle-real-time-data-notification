package com.intuit.demo.notification.common.mapper;

import com.intuit.demo.notification.service.kafka.dto.VehicleCdcEvent;
import com.intuit.demo.notification.service.kafka.dto.VehicleOverSpeedEvent;
import com.intuit.demo.notification.service.kafka.dto.VehicleRealTimeEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleEventMapper {
    VehicleEventMapper INSTANCE = Mappers.getMapper(VehicleEventMapper.class);

    VehicleOverSpeedEvent vehicleEventToOverSpeedEvent(VehicleRealTimeEvent vehicleRealTimeEvent);
}
