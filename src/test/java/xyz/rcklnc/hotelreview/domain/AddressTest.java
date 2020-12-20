package xyz.rcklnc.hotelreview.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AddressTest {
    @Test
    public void whenAddressIsGivenAnInvalidLatitude_thenItShouldThrowAIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> new Address("Address", 91.00, 180.00));
        assertThrows(IllegalArgumentException.class, ()-> new Address("Address", -91.00, -180.00));
    }

    @Test
    public void whenAddressIsGivenAnInvalidLongitude() {
        assertThrows(IllegalArgumentException.class, ()-> new Address("Address", 90.00, 181.00));
        assertThrows(IllegalArgumentException.class, ()-> new Address("Address", -90.00, -181.00));
    }
}
