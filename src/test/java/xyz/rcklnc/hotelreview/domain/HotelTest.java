package xyz.rcklnc.hotelreview.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    private Address aAddress;

    @BeforeEach
    public void setup() {
        this.aAddress = new Address(
            "Nieuwezijds Voorburgwal 147, 1012 RJ Amsterdam",
            52.373161,
            4.890900
        );
    }

    @Test
    public void whenAHotelIsCreatedWithNullAsAnId_thenItShouldThrowANullPointerException() {
        assertThrows(NullPointerException.class, () -> Hotel.from(
            null,
            null,
            this.aAddress
        ));
    }

    @Test
    public void givenTwoHotelsWithTheSameId_whenTheyAreCompared_thenTheyShouldBeEqual() {
        Hotel hotel = Hotel.from(
            HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"),
            "name",
            this.aAddress
        );
        Hotel hotel2 = Hotel.from(
            HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"),
            "name",
            this.aAddress
        );

        assertEquals(hotel, hotel2);
        assertEquals(new Address(
            "Nieuwezijds Voorburgwal 147, 1012 RJ Amsterdam",
            52.373161,
            4.890900
        ), hotel.getAddress());
    }

    @Test
    public void givenTwoHotelsWithDifferentIds_whenTheyAreCompared_thenTheyShouldNotBeEqual() {
        Hotel hotel = Hotel.from(
            HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"),
            "name",
            this.aAddress
        );
        Hotel hotel2 = Hotel.from(
            HotelId.from("bb4b3ccd-ec41-4734-a74a-588b9fd51cd2"),
            "name",
            this.aAddress
        );

        assertNotEquals(hotel, hotel2);
    }

    @Test
    public void givenTwoHotelsWithDifferentFieldsButTheSameId_whenTheyAreCompared_thenTheyShouldBeEqual() {
        Hotel hotel = Hotel.from(
            HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"),
            "name",
            this.aAddress
        );
        Hotel hotel2 = Hotel.from(
            HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"),
            "name2",
            this.aAddress
        );

        assertEquals(hotel, hotel2);
    }

    @Test
    public void whenANewHotelIsCreated_thenItShouldGenerateAUniqueIdForEachHotel() {
        Hotel aHotel = Hotel.create("A hotel", null);
        Hotel aSecondHotel = Hotel.create("A hotel", null);

        assertNotEquals(aHotel.getId(), aSecondHotel.getId());
    }

    @Test
    public void givenAHotel_whenTheNameIsChanged_thenTheNameShouldBeChanged() {
        Hotel aHotel = Hotel.create("A hotel", null);
        aHotel.changeName("A Changed Hotel");
        assertEquals("A Changed Hotel", aHotel.getName());
    }

    @Test
    public void givenAHotel_whenTheNameIsSetToNull_thenANullPointerExceptionShouldBeThrown() {
        Hotel aHotel = Hotel.create("A hotel", null);
        assertThrows(NullPointerException.class, () -> aHotel.changeName(null));
    }

    @Test
    public void givenAHotel_whenTheNameIsChanged_thenANameWasChangedEventShouldHaveBeenCreated() {
        Hotel aHotel = Hotel.from(
            HotelId.from("1d28320f-c9ff-4ec6-9744-1f4ae91cf936"),
            "A Hotel",
            null
        );
        aHotel.changeName("Changed Hotel Name");
        DomainEvent nameWasChangedEvent = aHotel.getEvents().get(0);

        assertEquals(1, aHotel.getEvents().size());
        assertTrue(nameWasChangedEvent instanceof HotelNameWasChanged);
        assertEquals(aHotel.getId(), ((HotelNameWasChanged) nameWasChangedEvent).getHotelId());
        assertEquals("Changed Hotel Name", ((HotelNameWasChanged) nameWasChangedEvent).getName());
    }

    @Test
    public void whenAHotelIsCreated_thenAHotelWasCreatedEventShouldHaveBeenCreated() {
        Hotel aHotel = Hotel.create("A hotel", this.aAddress);

        DomainEvent hotelWasCreatedEvent = aHotel.getEvents().get(0);

        assertEquals(1, aHotel.getEvents().size());
        assertTrue(hotelWasCreatedEvent instanceof HotelWasCreated);
        assertEquals(aHotel.getId(), ((HotelWasCreated) hotelWasCreatedEvent).getHotelId());
        assertEquals("A hotel", ((HotelWasCreated) hotelWasCreatedEvent).getName());

        assertEquals(
            new Address(
                "Nieuwezijds Voorburgwal 147, 1012 RJ Amsterdam",
                52.373161,
                4.890900
            ),
            ((HotelWasCreated) hotelWasCreatedEvent).getAddress()
        );
    }

    @Test
    public void givenAHotel_whenTheEventsListIsModified_thenItShouldThrowAUnsupportedOperationException() {
        Hotel aHotel = Hotel.create("A hotel", this.aAddress);
        assertThrows(UnsupportedOperationException.class, () -> aHotel.getEvents().add(new HotelNameWasChanged(
            aHotel.getId(),
            "changed"
        )));
    }
}
