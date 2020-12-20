package xyz.rcklnc.hotelreview.domain;


import lombok.Value;

@Value(staticConstructor = "from")
public class HotelWasCreated implements DomainEvent {
    HotelId hotelId;
    String name;
    Address address;

    public static HotelWasCreated from(Hotel hotel) {
        return new HotelWasCreated(hotel.getId(), hotel.getName(), hotel.getAddress());
    }
}
