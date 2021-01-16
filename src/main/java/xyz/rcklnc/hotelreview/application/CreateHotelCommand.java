package xyz.rcklnc.hotelreview.application;

import lombok.Value;

@Value
public class CreateHotelCommand {
    String hotelName;
    String addressLine;
    Double latitude;
    Double longitude;
}
