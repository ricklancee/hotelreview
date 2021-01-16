package xyz.rcklnc.hotelreview.application;

import lombok.Value;

@Value
public class CreateHotelInput {
    String hotelName;
    String addressLine;
    Double latitude;
    Double longitude;
}
