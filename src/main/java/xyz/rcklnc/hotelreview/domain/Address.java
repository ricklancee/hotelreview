package xyz.rcklnc.hotelreview.domain;

import lombok.NonNull;
import lombok.Value;

import javax.persistence.Embeddable;

@Value
@Embeddable
public class Address {
    String addressLine;
    Double latitude;
    Double longitude;

    private Address(@NonNull String addressLine, @NonNull Double latitude, @NonNull Double longitude) {
        if (latitude <= -90 || latitude > 90) {
            throw new IllegalArgumentException(latitude + " is not a valid latitude. Valid range from -90 to 90");
        }

        if (longitude <= -180 || longitude > 180) {
            throw new IllegalArgumentException(latitude.toString() + " is not a valid longitude, Valid range from -180 to 180");
        }

        this.addressLine = addressLine;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static Address of(String addressLine, Double latitude, Double longitude) {
        return new Address(addressLine, latitude, longitude);
    }
}
