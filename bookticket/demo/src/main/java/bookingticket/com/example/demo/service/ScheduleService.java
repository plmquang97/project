package bookingticket.com.example.demo.service;

import bookingticket.com.example.demo.api.request.ScheduleRequest;
import bookingticket.com.example.demo.entities.Movie;
import bookingticket.com.example.demo.entities.Schedule;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.service.dto.ScheduleMovieCinemaDto;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    List<Schedule> getAll();

    Schedule saveSchedule(ScheduleRequest scheduleRequest) throws ResourceNotFoundException;

    Optional<Schedule> findScheduleById(Integer id);

    void deleteScheduleById(Integer id);

    Schedule update(Integer id, ScheduleRequest scheduleRequest)throws ResourceNotFoundException;

    List<Movie> findByStartDateIs(String startDate);

    List<ScheduleMovieCinemaDto> findByCinemaIs(String cinemaName);
}
