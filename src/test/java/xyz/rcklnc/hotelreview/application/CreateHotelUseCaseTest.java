package xyz.rcklnc.hotelreview.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateHotelUseCaseTest {

    @Test
    public void givenValidHotelInput_whenExecutingTheUseCase_thenItRespondWithSuccess() {
        CreateHotelUseCase useCase = new CreateHotelUseCase();

        CreateHotelInput input = new CreateHotelInput(
            "Paleis op de Dam",
            "Nieuwezijds Voorburgwal 147, 1012 RJ Amsterdam",
            52.373161,
            4.890900
        );

        CreateHotelResponse response = useCase.execute(input);

        assertEquals(CreateHotelResponse.SUCCESS, response);
    }

    @Test
    public void givenInvalidLocationDetails_whenUseCaseIsExecuted_thenItRespondWithFailed() {
        CreateHotelUseCase useCase = new CreateHotelUseCase();

        CreateHotelInput input = new CreateHotelInput(
            "Paleis op de Dam",
            "Nieuwezijds Voorburgwal 147, 1012 RJ Amsterdam",
            200.,
            -200.
        );

        CreateHotelResponse response = useCase.execute(input);

        assertEquals(CreateHotelResponse.FAILED, response);
    }
}
