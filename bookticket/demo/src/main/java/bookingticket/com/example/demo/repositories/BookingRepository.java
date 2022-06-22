package bookingticket.com.example.demo.repositories;

import bookingticket.com.example.demo.entities.Booking;
import bookingticket.com.example.demo.entities.SeatingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    @Query("SELECT SUM(b.totalPrice) " +
            "FROM Booking b , Seats s , BookingDetail bD , Cinema c " +
            "WHERE b.id = bD.booking.id " +
            "AND bD.seats.id = s.id " +
            "AND s.cinemaRoom.cinema.id = c.id " +
            "AND s.seatingType = ?1 " +
            "AND c.cinemaName = ?2 ")
    Long getTotalRevenueOfSeatType(SeatingType seatingType, String cinemaName);
}
