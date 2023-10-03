package com.intuit.demo.notification.service.kafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehicleCdcEvent {

    private Payload payload;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Payload {

        private After after;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        public static class After {

            private Id id;
            private Distance distance;
            @JsonProperty("event_ts")
            private EventTs eventTs;
            private Fuel fuel;
            private Latitude latitude;
            private Longitude longitude;
            @JsonProperty("registration_number")
            private RegistrationNumber registrationNumber;
            private Speed speed;
            private Status status;
            @JsonProperty("update_ts")
            private UpdateTs updateTs;
            private Uuid uuid;

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @ToString
            public static class Id {

                private String value;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @ToString
            public static class Distance {

                private String value;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @ToString
            public static class EventTs {

                private String value;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @ToString
            public static class Fuel {

                private String value;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @ToString
            public static class Latitude {

                private String value;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @ToString
            public static class Longitude {

                private String value;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @ToString
            public static class RegistrationNumber {

                private String value;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @ToString
            public static class Speed {

                private String value;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @ToString
            public static class Status {

                private String value;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @ToString
            public static class UpdateTs {

                private String value;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @ToString
            public static class Uuid {

                private String value;
            }
        }
    }
}
