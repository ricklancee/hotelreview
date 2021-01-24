package xyz.rcklnc.hotelreview.usecases;

import lombok.Value;

@Value
public class CreateHotelParams {
    String hotelName;
    String addressLine;
    Double latitude;
    Double longitude;
}
