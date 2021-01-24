package xyz.rcklnc.hotelreview.domain;

import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class HotelId extends AggregateIdentifier {

    protected HotelId(UUID identifier) {
        super(identifier);
    }
}
