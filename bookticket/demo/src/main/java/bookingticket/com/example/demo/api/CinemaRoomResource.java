package bookingticket.com.example.demo.api;

import bookingticket.com.example.demo.api.request.CinemaRequest;
import bookingticket.com.example.demo.api.request.CinemaRoomRequest;
import bookingticket.com.example.demo.entities.CinemaRoom;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.service.CinemaRoomService;
import bookingticket.com.example.demo.service.dto.CinemaRoomDto;
import bookingticket.com.example.demo.service.mapper.CinemaRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@PreAuthorize("hasRole('ADMIN')")
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(CinemaRoomResource.PATH)
public class CinemaRoomResource {
    public static final String PATH = "/api/cinemaroom";

    @Autowired
    private CinemaRoomService cinemaRoomService;

    @Autowired
    private CinemaRoomMapper cinemaRoomMapper;

    @GetMapping
    public ResponseEntity<List<CinemaRoomDto>> getAll() {
        return ResponseEntity.ok(CinemaRoomMapper.INSTANCE.toDtos(cinemaRoomService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CinemaRoomDto> getCinemaRoomById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        CinemaRoom cinemaRoom = cinemaRoomService.findCinemaRoomById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CinemaRoom id not found :" + id));
        return ResponseEntity.ok(CinemaRoomMapper.INSTANCE.toDto(cinemaRoom));
    }

    @PostMapping
    ResponseEntity<CinemaRoomDto>create(@RequestBody CinemaRoomRequest cinemaRoomRequest){
        CinemaRoom createdCinemaRoom = cinemaRoomService.saveCinemaRoom(cinemaRoomRequest);
        return ResponseEntity
                .created(URI.create(CinemaRoomResource.PATH+"/"+ createdCinemaRoom.getCinemaRoomId()))
                .body(CinemaRoomMapper.INSTANCE.toDto(createdCinemaRoom));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable(value = "id")Integer id)throws ResourceNotFoundException{
        CinemaRoom cinemaRoom = cinemaRoomService.findCinemaRoomById(id)
                .orElseThrow(()-> new ResourceNotFoundException("CinemaRoom id not found :" + id));
        cinemaRoomService.deleteCinemaRoomById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CinemaRoomDto>update(@PathVariable(value ="id")Integer id,
                                               @RequestBody CinemaRoomRequest cinemaRoomRequest)throws ResourceNotFoundException{
        return ResponseEntity.ok(cinemaRoomMapper.toDto(cinemaRoomService.update(id,cinemaRoomRequest)));
    }

}

