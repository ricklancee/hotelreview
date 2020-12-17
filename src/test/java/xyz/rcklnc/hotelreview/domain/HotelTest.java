package xyz.rcklnc.hotelreview.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HotelTest {

    @Test
    public void twoIdsWithTheSameValueShouldBeEqual() {
        HotelId hotel1 = HotelId.of(1L);
        HotelId hotel2 = HotelId.of(1L);

        assertEquals(hotel1, hotel2);
    }

    @Test
    public void twoIdsWithTheDifferentValuesShouldNotBeEqual() {
        HotelId hotel1 = HotelId.of(1L);
        HotelId hotel2 = HotelId.of(2L);

        assertNotEquals(hotel1, hotel2);
    }
}
