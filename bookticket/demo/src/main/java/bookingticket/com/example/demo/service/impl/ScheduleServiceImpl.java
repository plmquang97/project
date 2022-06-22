package bookingticket.com.example.demo.service.impl;

import bookingticket.com.example.demo.api.request.ScheduleRequest;
import bookingticket.com.example.demo.entities.Movie;
import bookingticket.com.example.demo.entities.Schedule;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.repositories.ScheduleRepository;
import bookingticket.com.example.demo.service.CinemaService;
import bookingticket.com.example.demo.service.MovieService;
import bookingticket.com.example.demo.service.ScheduleService;
import bookingticket.com.example.demo.service.dto.ScheduleMovieCinemaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    private final MovieService movieService;

    private final CinemaService cinemaService;

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule saveSchedule(ScheduleRequest scheduleRequest) throws ResourceNotFoundException {
        Schedule newSchedule = new Schedule();
        newSchedule.setStartDate(scheduleRequest.getStartDate());
        newSchedule.setStartTime(scheduleRequest.getStartTime());
        newSchedule.setMovie(movieService.findMovieById(scheduleRequest.getMovieId()).orElseThrow (()->new ResourceNotFoundException("Movie id not found on " + scheduleRequest.getMovieId())));
        newSchedule.setCinema(cinemaService.findCinemaById(scheduleRequest.getCinemaId()).orElseThrow(()-> new ResourceNotFoundException("Cinema id not found on " +scheduleRequest.getCinemaId())));
        return scheduleRepository.save(newSchedule);
    }

    @Override
    public Optional<Schedule> findScheduleById(Integer id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public void deleteScheduleById(Integer id) {
    scheduleRepository.deleteById(id);
    }

    @Override
    public Schedule update (Integer id, ScheduleRequest scheduleRequest)throws ResourceNotFoundException{
        Schedule editSchedule = scheduleRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Schedule id not found : "+ id));
        editSchedule.setStartTime(scheduleRequest.getStartTime());
        editSchedule.setStartDate(scheduleRequest.getStartDate());
        editSchedule.setMovie(movieService.findMovieById(scheduleRequest.getMovieId()).orElseThrow(()-> new ResourceNotFoundException("Movie Id not found on " + scheduleRequest.getMovieId())));
        editSchedule.setCinema(cinemaService.findCinemaById(scheduleRequest.getCinemaId()).orElseThrow(()-> new ResourceNotFoundException("Cinema id not found on " + scheduleRequest.getCinemaId())));
        return scheduleRepository.save(editSchedule);

}

    @Override
    public List<Movie> findByStartDateIs(String startDate) {
        return scheduleRepository.findByStartDateIs(LocalDate.parse(startDate));
    }

    @Override
    public List<ScheduleMovieCinemaDto> findByCinemaIs(String cinemaName) {
        return scheduleRepository.findByCinemaContaining(cinemaName);
    }


}
