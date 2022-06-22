package bookingticket.com.example.demo.api;

import bookingticket.com.example.demo.api.request.SeatsRequest;
import bookingticket.com.example.demo.entities.Seats;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.service.SeatsService;
import bookingticket.com.example.demo.service.dto.SeatsDto;
import bookingticket.com.example.demo.service.mapper.SeatsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@PreAuthorize("hasRole('ADMIN')")
@RestController
@CrossOrigin(maxAge =3600)
@RequestMapping(SeatsResource.PATH)
public class SeatsResource {
    public static final String PATH = "/api/seats";

    @Autowired
    private SeatsService seatsService;

    @Autowired
    private SeatsMapper seatsMapper;

    @GetMapping
    ResponseEntity<List<SeatsDto>> getAll() {
        return ResponseEntity.ok(SeatsMapper.INSTANCE.toDtos(seatsService.getAll()));
    }

    @GetMapping("/{id}")
    ResponseEntity<SeatsDto> getSeatsById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Seats seats = seatsService.findSeatsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seats id not found :" + id));
        return ResponseEntity.ok(SeatsMapper.INSTANCE.toDto(seats));
    }

    @PostMapping
    public ResponseEntity<SeatsDto> create(@RequestBody SeatsRequest seatsRequest) {
        Seats createdSeats = seatsService.saveSeats(seatsRequest);
        return ResponseEntity
                .created(URI.create(SeatsResource.PATH + "/" + createdSeats.getSeatId()))
                .body(SeatsMapper.INSTANCE.toDto(createdSeats));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Seats seats = seatsService.findSeatsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seats id not found: " + id));
        seatsService.deleteSeatsById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeatsDto> update (@PathVariable(value ="id")Integer id,
                                            @RequestBody SeatsRequest seatsRequest)throws ResourceNotFoundException{
        return  ResponseEntity.ok(seatsMapper.toDto(seatsService.update(id,seatsRequest)));
    }

    @GetMapping("/getSeatingTypeAndCinemaType")
    public ResponseEntity<List<SeatsDto>> getSeatingTypeAndCinemaType (@RequestParam String seatingType, String cinemaType){
        return ResponseEntity.ok(SeatsMapper.INSTANCE.toDtos(seatsService.findBySeatingTypeAndCinemaType(seatingType,cinemaType)));
    }
}
