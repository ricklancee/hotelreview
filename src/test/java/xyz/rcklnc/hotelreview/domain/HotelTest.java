package xyz.rcklnc.hotelreview.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    public void whenAHotelIsCreatedWithNullAsAnId_thenItShouldThrowANullPointerException() {
        assertThrows(NullPointerException.class, () -> Hotel.from(
            null,
            null,
            null,
            null,
            null
        ));
    }

    @Test
    public void givenTwoHotelsWithTheSameId_whenTheyAreCompared_thenTheyShouldBeEqual() {
        Hotel hotel = Hotel.from(
            HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"),
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
    public void givenTwoHotelsWithDifferentFieldsButTheSameId_whenTheyAreCompared_thenTheyShouldBeEqual() {
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
    public void whenANewHotelIsCreated_thenItShouldGenerateAUniqueIdForEachHotel() {
        Hotel aHotel = Hotel.create("A hotel", null, null, null);
        Hotel aSecondHotel = Hotel.create("A hotel", null, null, null);

        assertNotEquals(aHotel.getId(), aSecondHotel.getId());
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
        assertThrows(NullPointerException.class, () -> aHotel.changeName(null));
    }

    @Test
    public void givenAHotel_whenTheNameIsChanged_thenANameWasChangedEventShouldHaveBeenCreated() {
        Hotel aHotel = Hotel.from(HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"), "A Hotel", null, null, null);
        aHotel.changeName("Changed Hotel Name");
        DomainEvent nameWasChangedEvent = aHotel.getEvents().get(0);

        assertEquals(1, aHotel.getEvents().size());
        assertTrue(nameWasChangedEvent instanceof HotelNameWasChanged);
        assertEquals(((HotelNameWasChanged) nameWasChangedEvent).getHotelId(), aHotel.getId());
        assertEquals(((HotelNameWasChanged) nameWasChangedEvent).getName(), "Changed Hotel Name");
    }
}
