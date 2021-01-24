package xyz.rcklnc.hotelreview.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
public class Hotel extends Aggregate {

    @EqualsAndHashCode.Include
    @Getter
    @EmbeddedId
    private final HotelId id;

    @Getter
    private String name;

    @Getter
    @Embedded
    private Address address;

    private Hotel(@NonNull HotelId id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static Hotel of(HotelId id, String name, Address address) {
        return new Hotel(id, name, address);
    }

    public static Hotel create(String name, Address address) {
        Hotel hotel = new Hotel(HotelId.create(), name, address);
        hotel.addEvent(HotelWasCreated.from(hotel));
        return hotel;
    }

    public void changeName(@NonNull String newName) {
        this.name = newName;

        addEvent(HotelNameWasChanged.from(this));
    }

    public void changeAddress(Address address) {
        this.address = address;

        addEvent(HotelAddressWasChanged.from(this));
    }
}
