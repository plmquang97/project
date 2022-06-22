package bookingticket.com.example.demo.repositories;

import bookingticket.com.example.demo.entities.Booking;
import bookingticket.com.example.demo.entities.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.cert.Certificate;
import java.util.List;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetail, Integer> {
    List<BookingDetail> findByBookingBookingId(Integer id);
}
