package xyz.rcklnc.hotelreview.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelIdTest {

    @Test
    public void twoHotelsWithTheSameValuesShouldBeEqual() {
        Hotel hotel = Hotel.of(HotelId.of(1L), "name", "d", "a");
        Hotel hotel2 = Hotel.of(HotelId.of(1L), "name", "d", "a");

        assertEquals(hotel, hotel2);
    }

    @Test
    public void twoHotelsWithDifferentIdsShouldNotBeEqual() {
        Hotel hotel = Hotel.of(HotelId.of(1L), "name", "d", "a");
        Hotel hotel2 = Hotel.of(HotelId.of(2L), "name", "d", "a");

        assertNotEquals(hotel, hotel2);
    }

    @Test
    public void twoHotelsWithDifferentFieldsButSameIdsShouldStillBeEqual() {
        Hotel hotel = Hotel.of(HotelId.of(1L), "name", "d", "a");
        Hotel hotel2 = Hotel.of(HotelId.of(1L), "name2", "d2", "a2");

        assertEquals(hotel, hotel2);
    }

}
