package xyz.rcklnc.hotelreview.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    public void givenTwoHotelsWithTheSameIds_whenTheyAreCompare_thenTheyShouldBeEqual() {
        Hotel hotel = Hotel.from(HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"),
            "name",
            "a",
            52.3605759,
            4.9159683
        );
        Hotel hotel2 = Hotel.from(
            HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"),
            "name",
            "a",
            52.3605759,
            4.9159683
        );

        assertEquals(hotel, hotel2);
    }

    @Test
    public void givenTwoHotelsWithDifferentIds_whenTheyAreCompared_thenTheyShouldNotBeEqual() {
        Hotel hotel = Hotel.from(
            HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"),
            "name",
            "a",
            52.3605759,
            4.9159683
        );
        Hotel hotel2 = Hotel.from(
            HotelId.from("bb4b3ccd-ec41-4734-a74a-588b9fd51cd2"),
            "name",
            "a",
            52.3605759,
            4.9159683
        );

        assertNotEquals(hotel, hotel2);
    }

    @Test
    public void givenTwoHotelsWithDifferentFieldsButTheSameId_whenTheAreCompared_thenTheyShouldBeEqual() {
        Hotel hotel = Hotel.from(
            HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"),
            "name",
            "a",
            52.3605759,
            4.9159683
        );
        Hotel hotel2 = Hotel.from(
            HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"),
            "name2",
            "a2",
            52.3605759,
            4.9159683
        );

        assertEquals(hotel, hotel2);
    }

    @Test
    public void givenAHotel_whenTheNameIsChanged_thenTheNameShouldBeChanged() {
        Hotel aHotel = Hotel.create("A hotel", null, null, null);
        aHotel.changeName("A Changed Hotel");
        assertEquals("A Changed Hotel", aHotel.getName());
    }

    @Test
    public void givenAHotel_whenTheNameIsSetToNull_thenANullPointerExceptionShouldBeThrown() {
        Hotel aHotel = Hotel.create("A hotel", null, null, null);
        assertThrows(NullPointerException.class, () -> {
            aHotel.changeName(null);
        });
    }
}
