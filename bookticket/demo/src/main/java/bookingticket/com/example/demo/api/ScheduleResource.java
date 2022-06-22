package bookingticket.com.example.demo.api;

import bookingticket.com.example.demo.api.request.ScheduleRequest;
import bookingticket.com.example.demo.entities.Schedule;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.service.CinemaService;
import bookingticket.com.example.demo.service.MovieService;
import bookingticket.com.example.demo.service.ScheduleService;
import bookingticket.com.example.demo.service.dto.MovieDto;
import bookingticket.com.example.demo.service.dto.ScheduleDto;
import bookingticket.com.example.demo.service.dto.ScheduleMovieCinemaDto;
import bookingticket.com.example.demo.service.mapper.MovieMapper;
import bookingticket.com.example.demo.service.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@PreAuthorize("hasRole('ADMIN')")
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(ScheduleResource.PATH)
public class ScheduleResource {
    public static final String PATH = "/api/schedule";

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @GetMapping
    ResponseEntity<List<ScheduleDto>>getAll(){
        return ResponseEntity.ok(ScheduleMapper.INSTANCE.toDtos(scheduleService.getAll()));
    }

    @GetMapping("/{id}")
    ResponseEntity<ScheduleDto>getScheduleById(@PathVariable(value ="id")Integer id)throws ResourceNotFoundException{
        Schedule schedule = scheduleService.findScheduleById(id)
                .orElseThrow(()->new ResourceNotFoundException("Schedule id not found : "+ id));
        return ResponseEntity.ok(ScheduleMapper.INSTANCE.toDto(schedule));
    }

    @PostMapping
    public ResponseEntity<ScheduleDto> create(@RequestBody ScheduleRequest scheduleRequest) throws ResourceNotFoundException{
        Schedule createSchedule = new Schedule();
        createSchedule.setCinema(cinemaService.findCinemaById(scheduleRequest.getCinemaId()).orElseThrow(()-> new ResourceNotFoundException("Cinema not found " + scheduleRequest.getCinemaId())));
        createSchedule.setMovie(movieService.findMovieById(scheduleRequest.getMovieId()).orElseThrow(()-> new ResourceNotFoundException("Movie not found " + scheduleRequest.getMovieId())));
        return ResponseEntity
                .created(URI.create(ScheduleResource.PATH+"/"+createSchedule.getScheduleId()))
                .body(ScheduleMapper.INSTANCE.toDto(createSchedule));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ScheduleDto>delete (@PathVariable(value ="id")Integer id)throws ResourceNotFoundException{
        Schedule schedule = scheduleService.findScheduleById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Schedule id not found : "+ id));
        scheduleService.deleteScheduleById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleDto> update (@PathVariable(value ="id")Integer id,
                                               @RequestBody ScheduleRequest scheduleRequest)throws ResourceNotFoundException{
        return ResponseEntity.ok(scheduleMapper.toDto(scheduleService.update(id,scheduleRequest)));
    }

    @GetMapping("/getByStartDateIs")
   public ResponseEntity<List<MovieDto>> getByStartDateIs(@RequestParam String startDate){
        return ResponseEntity.ok(MovieMapper.INSTANCE.toDtos(scheduleService.findByStartDateIs(startDate)));
    }

    @GetMapping("/getByCinemaIs")
    public ResponseEntity<List<ScheduleMovieCinemaDto>> getCinemaAndItsMovie(@RequestParam(value = "cinemaName")String cinemaName){
       return ResponseEntity.ok(scheduleService.findByCinemaIs(cinemaName));
    }
}
