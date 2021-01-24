package xyz.rcklnc.hotelreview.domain;

public interface HotelRepository {
    Hotel findByAddress(Address address);
    void save(Hotel hotel);
}
