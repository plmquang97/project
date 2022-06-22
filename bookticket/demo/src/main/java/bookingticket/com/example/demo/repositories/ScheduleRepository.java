package bookingticket.com.example.demo.repositories;

import bookingticket.com.example.demo.entities.Movie;
import bookingticket.com.example.demo.entities.Schedule;
import bookingticket.com.example.demo.service.dto.ScheduleMovieCinemaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {

    @Query("SELECT s.movie FROM Schedule s WHERE s.startDate = :startDate")
    List<Movie> findByStartDateIs(@Param("startDate") LocalDate startDate);

    @Query("SELECT distinct new bookingticket.com.example.demo.service.dto.ScheduleMovieCinemaDto(c.cinemaName, m.name) " +
            "FROM Schedule s , Cinema c , Movie m " +
            "WHERE s.cinema.cinemaId = c.cinemaId AND c.cinemaName = :cinemaName")
    List<ScheduleMovieCinemaDto> findByCinemaContaining(@Param("cinemaName") String cinemaName);







}
