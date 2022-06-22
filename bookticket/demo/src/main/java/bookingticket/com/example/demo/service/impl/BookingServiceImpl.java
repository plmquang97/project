package bookingticket.com.example.demo.service.impl;

import bookingticket.com.example.demo.entities.Booking;
import bookingticket.com.example.demo.entities.SeatingType;
import bookingticket.com.example.demo.repositories.BookingRepository;
import bookingticket.com.example.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> findBookingById(Integer id) {
        return bookingRepository.findById(id);
    }

    @Override
    public void deleteBookingById(Integer id) {
        bookingRepository.deleteById(id);

    }

    @Override
    public Long getTotalRevenueOfSeatType(String seatingType, String cinemaName) {
        return bookingRepository.getTotalRevenueOfSeatType(SeatingType.valueOf(seatingType),cinemaName);

    }
}
