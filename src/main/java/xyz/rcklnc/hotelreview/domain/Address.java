package xyz.rcklnc.hotelreview.domain;

import lombok.Value;

@Value
public class Address {
    String addressLine;
    Double latitude;
    Double Longitude;
}
