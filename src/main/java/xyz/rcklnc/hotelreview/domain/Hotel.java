package xyz.rcklnc.hotelreview.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public class Hotel {
    @EqualsAndHashCode.Include
    private final HotelId id;
    private final String name;
    private final String country;
    private final String address;

    private Hotel(HotelId id, String name, String country, String address) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
    }

    public static Hotel of(HotelId id, String name, String country, String address) {
        return new Hotel(id, name, country, address);
    }
}
