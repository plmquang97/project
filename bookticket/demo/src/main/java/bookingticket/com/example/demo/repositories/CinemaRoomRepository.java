package bookingticket.com.example.demo.repositories;

import bookingticket.com.example.demo.entities.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Integer> {
}
