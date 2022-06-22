package bookingticket.com.example.demo.repositories;

import bookingticket.com.example.demo.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    List<Movie> findByDirectorContaining(String director);

    List<Movie> findByActorContaining(String actor);

    List<Movie> findByReleaseDateBetween(LocalDate fromDate , LocalDate toDate);


}
