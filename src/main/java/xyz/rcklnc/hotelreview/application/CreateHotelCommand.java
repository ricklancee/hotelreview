package xyz.rcklnc.hotelreview.application;

import lombok.Value;
import xyz.rcklnc.hotelreview.domain.Address;

@Value
public class CreateHotelCommand {
    String hotelName;
    Address address; 
}
