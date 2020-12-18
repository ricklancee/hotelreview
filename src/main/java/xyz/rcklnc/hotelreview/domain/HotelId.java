package xyz.rcklnc.hotelreview.domain;

import java.util.UUID;

public class HotelId extends AggregateIdentifier {

    protected HotelId(UUID identifier) {
        super(identifier);
    }
}
