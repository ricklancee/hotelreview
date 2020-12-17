package xyz.rcklnc.hotelreview.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@EqualsAndHashCode
@Getter
public class HotelId {
    private final UUID identifier;

    private HotelId(UUID identifier) {
        this.identifier = identifier;
    }

    public static HotelId from(@NonNull String identifier) {
        return new HotelId(UUID.fromString(identifier));
    }

    public static HotelId create() {
        return new HotelId(UUID.randomUUID());
    }
}
