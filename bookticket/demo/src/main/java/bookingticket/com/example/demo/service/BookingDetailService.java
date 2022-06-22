package bookingticket.com.example.demo.service;

import bookingticket.com.example.demo.entities.BookingDetail;

import java.util.List;
import java.util.Optional;

public interface BookingDetailService {
    List<BookingDetail> getAll();

    BookingDetail saveBookingDetail(BookingDetail bookingDetail);

    Optional<BookingDetail> findBookingDetailById(Integer id);

    void deleteBookingById(Integer id);

    List<BookingDetail> findByBookingBookingId(Integer id);
}
