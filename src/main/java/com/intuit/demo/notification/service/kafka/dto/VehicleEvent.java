package com.intuit.demo.notification.service.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleEvent implements Serializable {

    private String id;
    private String uuid;
    private String registrationNumber;
    private String status;
    private Double latitude;
    private Double longitude;
    private Double speed;
    private Double distance;
    private Double fuel;
    private String timestamp;
    private String receivedTimestamp;
}
