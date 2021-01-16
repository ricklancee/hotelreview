package xyz.rcklnc.hotelreview.application;

import org.junit.jupiter.api.Test;
import xyz.rcklnc.hotelreview.domain.Address;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateHotelUseCaseTest {

    @Test
    public void givenAUseCase_whenTheUseCaseIsExecuted_thenItShouldSuccessfullyExecute() {
        CreateHotelUseCase useCase = new CreateHotelUseCase();

        Address address = Address.of(
            "Nieuwezijds Voorburgwal 147, 1012 RJ Amsterdam",
            52.373161,
            4.890900
        );

        CreateHotelCommand command = new CreateHotelCommand(
            "Paleis op de Dam",
            address
        );

        CreateHotelResponse response = useCase.execute(command);

        assertEquals(CreateHotelResponse.SUCCESS, response);
    }
}
