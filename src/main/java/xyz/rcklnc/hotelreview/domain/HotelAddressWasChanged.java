package xyz.rcklnc.hotelreview.domain;

import lombok.Value;

@Value(staticConstructor = "from")
public class HotelAddressWasChanged implements DomainEvent{
    HotelId hotelId;
    String addressLine;
    Double latitude;
    Double longitude;

    public static HotelAddressWasChanged from(Hotel hotel) {
        return new HotelAddressWasChanged(
            hotel.getId(),
            hotel.getAddress().getAddressLine(),
            hotel.getAddress().getLatitude(),
            hotel.getAddress().getLongitude()
        );
    }
}
