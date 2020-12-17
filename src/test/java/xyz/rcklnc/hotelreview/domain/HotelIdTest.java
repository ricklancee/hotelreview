package xyz.rcklnc.hotelreview.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HotelIdTest {

    @Test
    public void twoIdsWithTheSameValueShouldBeEqual() {
        HotelId hotelID1 = HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936");
        HotelId hotelID2 = HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936");

        assertEquals(hotelID1, hotelID2);
    }

    @Test
    public void twoIdsWithTheDifferentValuesShouldNotBeEqual() {
        HotelId hotelID1 = HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936");
        HotelId hotelID2 = HotelId.from("bb4b3ccd-ec41-4734-a74a-588b9fd51cd2");

        assertNotEquals(hotelID1, hotelID2);
    }

    @Test
    public void creatingANewIdShouldCreateARandomId() {
        HotelId hotelId1 = HotelId.create();
        HotelId hotelId2 = HotelId.create();

        assertNotEquals(hotelId1, hotelId2);
    }
}
