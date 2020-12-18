package xyz.rcklnc.hotelreview.domain;

import lombok.Value;

@Value
public class HotelNameWasChanged implements DomainEvent {
    HotelId hotelId;
    String name;
}
