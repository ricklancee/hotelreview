package xyz.rcklnc.hotelreview.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Hotel extends Aggregate {

    @EqualsAndHashCode.Include
    @Getter
    private final HotelId id;

    @Getter
    private String name;

    @Getter
    private final Address address;

    private Hotel(@NonNull HotelId id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static Hotel from(HotelId id, String name, Address address) {
        return new Hotel(id, name, address);
    }

    public static Hotel create(String name, Address address) {
        Hotel hotel = from(HotelId.create(), name, address);
        hotel.addEvent(new HotelWasCreated(hotel.id, hotel.name, hotel.address));
        return hotel;
    }

    public void changeName(@NonNull String newName) {
        this.name = newName;

        addEvent(new HotelNameWasChanged(this.id, this.name));
    }

}
