package bookingticket.com.example.demo.repositories;

import bookingticket.com.example.demo.entities.CinemaType;
import bookingticket.com.example.demo.entities.SeatingType;
import bookingticket.com.example.demo.entities.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seats,Integer> {
    @Query("FROM Seats s " +
            "WHERE s.seatingType = ?1 " +
            "AND s.cinemaRoom.cinemaType = ?2 ")
    List<Seats>getSeatBySeatingTypeAndCinemaRoomType(SeatingType seatingType, CinemaType cinemaType);
}
