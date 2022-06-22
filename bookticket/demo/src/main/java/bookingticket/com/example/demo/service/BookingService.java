package bookingticket.com.example.demo.service;

import bookingticket.com.example.demo.entities.Booking;
import bookingticket.com.example.demo.entities.SeatingType;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> getAll();

    Booking saveBooking(Booking booking);

    Optional<Booking> findBookingById(Integer id);

    void deleteBookingById(Integer id);

//    Long getTotalRevenueOfSeatType(String seatingType);

    Long getTotalRevenueOfSeatType(String seatingType, String cinemaName);
}
