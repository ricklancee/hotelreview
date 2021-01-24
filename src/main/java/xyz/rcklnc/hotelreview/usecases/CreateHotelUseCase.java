package xyz.rcklnc.hotelreview.usecases;

import lombok.RequiredArgsConstructor;
import xyz.rcklnc.hotelreview.domain.Address;
import xyz.rcklnc.hotelreview.domain.Hotel;
import xyz.rcklnc.hotelreview.domain.HotelRepository;

@RequiredArgsConstructor
public class CreateHotelUseCase {

    private final HotelRepository hotelRepository;

    public void execute(CreateHotelParams input) {
        Hotel hotel = Hotel.create(
            input.getHotelName(),
            Address.of(
                input.getAddressLine(),
                input.getLatitude(),
                input.getLongitude()
            )
        );

        this.hotelRepository.save(hotel);
    }

}
