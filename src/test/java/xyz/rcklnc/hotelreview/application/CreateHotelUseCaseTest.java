package xyz.rcklnc.hotelreview.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateHotelUseCaseTest {

    @Test
    public void givenAUseCase_whenGivenAValidCreteHotelCommand_thenItShouldSuccessfullyExecute() {
        CreateHotelUseCase useCase = new CreateHotelUseCase();

        CreateHotelInput command = new CreateHotelInput(
            "Paleis op de Dam",
            "Nieuwezijds Voorburgwal 147, 1012 RJ Amsterdam",
            52.373161,
            4.890900
        );

        CreateHotelResponse response = useCase.execute(command);

        assertEquals(CreateHotelResponse.SUCCESS, response);
    }

    @Test
    public void givenAUseCase_whenGivenInvalidLocationDetails_thenItShouldFail() {
        CreateHotelUseCase useCase = new CreateHotelUseCase();

        CreateHotelInput command = new CreateHotelInput(
            "Paleis op de Dam",
            "Nieuwezijds Voorburgwal 147, 1012 RJ Amsterdam",
            200.,
            -200.
        );

        CreateHotelResponse response = useCase.execute(command);

        assertEquals(CreateHotelResponse.FAILED, response);
    }
}
