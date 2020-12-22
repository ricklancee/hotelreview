package xyz.rcklnc.hotelreview.domain;

import lombok.Value;

import java.time.Instant;

@Value(staticConstructor = "from")
public class HotelNameWasChanged implements DomainEvent {
    Instant occurredOn;
    HotelId hotelId;
    String name;

    public static HotelNameWasChanged from(Hotel hotel) {
        return new HotelNameWasChanged(Instant.now(), hotel.getId(), hotel.getName());
    }
}
