package xyz.rcklnc.hotelreview.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@EqualsAndHashCode
@Getter
public class HotelId {
    private final Long identifier;

    private HotelId(Long identifier) {
        this.identifier = identifier;
    }

    public static HotelId of(@NonNull Long identifier) {
        return new HotelId(identifier);
    }
}
