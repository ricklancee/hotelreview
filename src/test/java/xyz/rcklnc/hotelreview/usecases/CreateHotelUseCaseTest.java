package xyz.rcklnc.hotelreview.usecases;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import xyz.rcklnc.hotelreview.domain.Address;
import xyz.rcklnc.hotelreview.domain.Hotel;
import xyz.rcklnc.hotelreview.domain.HotelRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateHotelUseCaseTest {

    @Test
    public void givenValidHotelInput_whenExecutingTheUseCase_thenItRespondWithSuccess() {
        HotelRepository mock = mock(HotelRepository.class);
        ArgumentCaptor<Hotel> argumentCaptor = ArgumentCaptor.forClass(Hotel.class);
        CreateHotelUseCase useCase = new CreateHotelUseCase(mock);

        CreateHotelParams input = new CreateHotelParams(
            "Paleis op de Dam",
            "Nieuwezijds Voorburgwal 147, 1012 RJ Amsterdam",
            52.373161,
            4.890900
        );

        useCase.execute(input);

        verify(mock).save(argumentCaptor.capture());
        assertEquals("Paleis op de Dam", argumentCaptor.getValue().getName());
        assertNotNull(argumentCaptor.getValue().getId());
        assertEquals(
            Address.of(
                "Nieuwezijds Voorburgwal 147, 1012 RJ Amsterdam",
                52.373161,
                4.890900
            ),
            argumentCaptor.getValue().getAddress()
        );
    }

}
