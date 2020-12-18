package xyz.rcklnc.hotelreview.domain;

import lombok.Value;

@Value
public class HotelAddressWasChanged implements DomainEvent{
    HotelId hotelId;
    String addressLine;
    Double latitude;
    Double longitude;
}
