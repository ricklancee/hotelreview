package xyz.rcklnc.hotelreview.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Address {
    private final String addressLine;
    private final Double latitude;
    private final Double longitude;

    @NonNull
    public Address(String addressLine, Double latitude, Double longitude) {
        if (latitude <= -90 || latitude > 90) {
            throw new IllegalArgumentException(latitude.toString() + " is not a valid latitude. Valid range from -90 to 90");
        }

        if (longitude <= -180 || longitude > 180) {
            throw new IllegalArgumentException(latitude.toString() + " is not a valid longitude, Valid range from -180 to 180");
        }

        this.addressLine = addressLine;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
