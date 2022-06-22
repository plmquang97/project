package bookingticket.com.example.demo.service.impl;

import bookingticket.com.example.demo.entities.BookingDetail;
import bookingticket.com.example.demo.repositories.BookingDetailRepository;
import bookingticket.com.example.demo.service.BookingDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingDetailServiceImpl implements BookingDetailService {
    private final BookingDetailRepository bookingDetailRepository;

    @Override
    public List<BookingDetail> getAll() {
        return bookingDetailRepository.findAll();
    }

    @Override
    public BookingDetail saveBookingDetail(BookingDetail bookingDetail) {
        return bookingDetailRepository.save(bookingDetail);
    }

    @Override
    public Optional<BookingDetail> findBookingDetailById(Integer id) {
        return bookingDetailRepository.findById(id);
    }

    @Override
    public void deleteBookingById(Integer id) {
        bookingDetailRepository.deleteById(id);
    }

    @Override
    public List<BookingDetail> findByBookingBookingId(Integer id) {
        return bookingDetailRepository.findByBookingBookingId(id);
    }
}
