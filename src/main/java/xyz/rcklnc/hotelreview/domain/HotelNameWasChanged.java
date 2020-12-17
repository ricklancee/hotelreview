package xyz.rcklnc.hotelreview.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HotelNameWasChanged implements DomainEvent {
    private final HotelId hotelId;
    private final String name;
}
