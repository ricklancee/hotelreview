package xyz.rcklnc.hotelreview.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel {
    private final List<DomainEvent> events = new ArrayList<>();

    @EqualsAndHashCode.Include
    private final HotelId id;

    private String name;

    private final String address;

    private final Double latitude;

    private final Double longitude;

    private Hotel(HotelId id, String name, String address, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static Hotel from(HotelId id, String name, String address, Double latitude, Double longitude) {
        return new Hotel(id, name, address, latitude, longitude);
    }

    public static Hotel create(String name, String address, Double latitude, Double longitude) {
        return from(HotelId.create(), name, address, latitude, longitude);
    }

    public void changeName(@NonNull String newName) {
        this.name = newName;

        addEvent(new HotelNameWasChanged(this.id, this.name));
    }

    private void addEvent(DomainEvent event) {
        this.events.add(event);
    }
}
