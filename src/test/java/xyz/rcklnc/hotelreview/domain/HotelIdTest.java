package xyz.rcklnc.hotelreview.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelIdTest {

    @Test
    public void twoHotelsWithTheSameValuesShouldBeEqual() {
        Hotel hotel = Hotel.of(HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"), "name", "d", "a");
        Hotel hotel2 = Hotel.of(HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"), "name", "d", "a");

        assertEquals(hotel, hotel2);
    }

    @Test
    public void twoHotelsWithDifferentIdsShouldNotBeEqual() {
        Hotel hotel = Hotel.of(HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"), "name", "d", "a");
        Hotel hotel2 = Hotel.of(HotelId.from("bb4b3ccd-ec41-4734-a74a-588b9fd51cd2"), "name", "d", "a");

        assertNotEquals(hotel, hotel2);
    }

    @Test
    public void twoHotelsWithDifferentFieldsButSameIdsShouldStillBeEqual() {
        Hotel hotel = Hotel.of(HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"), "name", "d", "a");
        Hotel hotel2 = Hotel.of(HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"), "name2", "d2", "a2");

        assertEquals(hotel, hotel2);
    }

}
