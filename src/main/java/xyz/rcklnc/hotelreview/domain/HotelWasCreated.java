package xyz.rcklnc.hotelreview.domain;

import lombok.Value;

@Value
public class HotelWasCreated implements DomainEvent {
    HotelId hotelId;
    String name;
    String address;
    Double latitude;
    Double longitude;
}
