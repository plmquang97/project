package bookingticket.com.example.demo.api;

import bookingticket.com.example.demo.api.request.CinemaRequest;
import bookingticket.com.example.demo.entities.Cinema;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.service.CinemaService;
import bookingticket.com.example.demo.service.dto.CinemaDto;
import bookingticket.com.example.demo.service.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@PreAuthorize("hasRole('ADMIN')")
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(CinemaResource.PATH)
public class CinemaResource {
public static final String PATH ="/api/cinema";

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private CinemaMapper cinemaMapper;


    @GetMapping
    ResponseEntity<List<CinemaDto>>getAll(){
        return ResponseEntity.ok(CinemaMapper.INSTANCE.toDtos(cinemaService.getAll()));
    }

    @GetMapping("/{id}")
    ResponseEntity<CinemaDto>getCinemaById(@PathVariable(value ="id")Integer id)throws ResourceNotFoundException{
        Cinema cinema =cinemaService.findCinemaById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cinema id not found : "+ id));
        return ResponseEntity.ok(CinemaMapper.INSTANCE.toDto(cinema));
    }

    @PostMapping
    public ResponseEntity<CinemaDto>create (@RequestBody CinemaRequest cinemaRequest){
        Cinema createdCinema = cinemaService.saveCinema(cinemaRequest);
        return ResponseEntity
                .created(URI.create(CinemaResource.PATH+ "/" + createdCinema.getCinemaId()))
                .body(CinemaMapper.INSTANCE.toDto(createdCinema));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable(value="id")Integer id)throws ResourceNotFoundException{
        Cinema cinema = cinemaService.findCinemaById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cinema id not found :" + id));
        cinemaService.deleteCinemaById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CinemaDto> update(@PathVariable (value ="id")Integer id,
                                            @RequestBody CinemaRequest cinemaRequest)throws ResourceNotFoundException{
        return ResponseEntity.ok(cinemaMapper.toDto(cinemaService.update(id,cinemaRequest)));
    }
}
