package com.intuit.demo.notification.service.kafka.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VehicleOverSpeedEvent implements Serializable {

    private String id;
    private String uuid;
    private String registrationNumber;
    private Double latitude;
    private Double longitude;
    private String status;
    private Double speed;
    private Double fuel;
    private Double distance;
    private String timestamp;
}
