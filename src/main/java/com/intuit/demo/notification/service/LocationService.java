package com.intuit.demo.notification.service;

import reactor.util.function.Tuple2;

public interface LocationService<T, D> {

    double calculateDistance(Tuple2<T, D> currentGeoLocation, Tuple2<T, D> lastKnownGeoLocation, double averageSpeed);
}
