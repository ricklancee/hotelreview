package xyz.rcklnc.hotelreview.application;

import lombok.extern.slf4j.Slf4j;
import xyz.rcklnc.hotelreview.domain.Address;
import xyz.rcklnc.hotelreview.domain.Hotel;

@Slf4j
public class CreateHotelUseCase {

    public CreateHotelResponse execute(CreateHotelInput command) {
        try {
            Hotel.create(
                command.getHotelName(),
                Address.of(
                    command.getAddressLine(),
                    command.getLatitude(),
                    command.getLongitude()
                )
            );

            return CreateHotelResponse.SUCCESS;
        } catch (Exception e) {
            CreateHotelUseCase.log.error("Failed executing use case", e);
            return CreateHotelResponse.FAILED;
        }
    }
}
