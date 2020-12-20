package xyz.rcklnc.hotelreview.domain;

import lombok.Value;

@Value(staticConstructor = "from")
public class HotelNameWasChanged implements DomainEvent {
    HotelId hotelId;
    String name;

    public static HotelNameWasChanged from(Hotel hotel) {
        return new HotelNameWasChanged(hotel.getId(), hotel.getName());
    }
}
