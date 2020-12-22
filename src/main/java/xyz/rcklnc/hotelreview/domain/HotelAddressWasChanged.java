package xyz.rcklnc.hotelreview.domain;

import lombok.Value;

import java.time.Instant;

@Value(staticConstructor = "from")
public class HotelAddressWasChanged implements DomainEvent {
    Instant occurredOn;
    HotelId hotelId;
    String addressLine;
    Double latitude;
    Double longitude;

    public static HotelAddressWasChanged from(Hotel hotel) {
        return new HotelAddressWasChanged(
            Instant.now(),
            hotel.getId(),
            hotel.getAddress().getAddressLine(),
            hotel.getAddress().getLatitude(),
            hotel.getAddress().getLongitude()
        );
    }
}
