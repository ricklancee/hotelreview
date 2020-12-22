package xyz.rcklnc.hotelreview.domain;


import lombok.Value;

import java.time.Instant;

@Value(staticConstructor = "from")
public class HotelWasCreated implements DomainEvent {
    Instant occurredOn;
    HotelId hotelId;
    String name;
    Address address;

    public static HotelWasCreated from(Hotel hotel) {
        return new HotelWasCreated(Instant.now(), hotel.getId(), hotel.getName(), hotel.getAddress());
    }
}
