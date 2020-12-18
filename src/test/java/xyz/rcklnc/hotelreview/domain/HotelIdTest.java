package xyz.rcklnc.hotelreview.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class HotelIdTest {

    @Test
    public void givenAStringThatIsNotAValidUUID_whenAnIdIsCreated_thenItShouldThrownAException() {
        assertThrows(IllegalArgumentException.class, () -> HotelId.from("not-a-valid-uuid"));
    }

    @Test
    public void givenAId_whenItsComparedToAUUIDWithTheSameValue_thenTheyShouldBeEqual() {
        HotelId hotelID = HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936");

        assertEquals(UUID.fromString("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"), hotelID.getIdentifier());
    }

    @Test
    public void givenAId_whenItsComparedToAUUIDWithTheADifferentValue_thenTheyShouldNotBeEqual() {
        HotelId hotelID = HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936");

        assertNotEquals(UUID.fromString("bb4b3ccd-ec41-4734-a74a-588b9fd51cd2"), hotelID.getIdentifier());
    }

    @Test
    public void givenTwoIdsWithTheSameValue_whenTheyAreCompared_thenTheyShouldBeEqual() {
        HotelId hotelID1 = HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936");
        HotelId hotelID2 = HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936");

        assertEquals(hotelID1, hotelID2);
    }

    @Test
    public void givenTwoIdsWithTheDifferentValues_whenTheyAreCompared_thenTheyShouldNotBeEqual() {
        HotelId hotelID1 = HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936");
        HotelId hotelID2 = HotelId.from("bb4b3ccd-ec41-4734-a74a-588b9fd51cd2");

        assertNotEquals(hotelID1, hotelID2);
    }

    @Test
    public void givenTwoNewlyCreatedIds_whenTheyAreCompared_theyShouldNotBeEqual() {
        HotelId hotelId1 = HotelId.create();
        HotelId hotelId2 = HotelId.create();

        assertNotEquals(hotelId1, hotelId2);
    }
}
