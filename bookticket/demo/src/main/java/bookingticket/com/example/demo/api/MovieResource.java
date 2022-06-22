package bookingticket.com.example.demo.api;

import bookingticket.com.example.demo.api.request.MovieRequest;
import bookingticket.com.example.demo.entities.Movie;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.service.MovieService;
import bookingticket.com.example.demo.service.dto.MovieDto;
import bookingticket.com.example.demo.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
@PreAuthorize("hasRole('ADMIN')")
@RestController
@CrossOrigin(maxAge =3600)
@RequestMapping(MovieResource.PATH)
public class MovieResource {
    public static final String PATH = "/api/movie";

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;

    @GetMapping
    public ResponseEntity<List<MovieDto>>getAll(){
        return ResponseEntity.ok(MovieMapper.INSTANCE.toDtos(movieService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto>getMovieById(@PathVariable(value="id")Integer id) throws ResourceNotFoundException{
        Movie movie = movieService.findMovieById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Movie id not found :" + id));
        return ResponseEntity.ok(MovieMapper.INSTANCE.toDto(movie));
    }

    @PostMapping
    public ResponseEntity<MovieDto> create (@RequestBody MovieRequest movieRequest){
        Movie createdMovie = movieService.saveMovie(movieRequest);
        return ResponseEntity
                .created(URI.create(MovieResource.PATH+"/"+ createdMovie.getMovieId()))
                .body(MovieMapper.INSTANCE.toDto(createdMovie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable(value="id")Integer id)throws ResourceNotFoundException{
        Movie movie = movieService.findMovieById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Movie id not found "+ id));
        movieService.deleteMovieById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update (@PathVariable(value="id")Integer id ,
                                            @RequestBody MovieRequest movieRequest) throws ResourceNotFoundException{
        return ResponseEntity.ok(movieMapper.toDto(movieService.update(id,movieRequest)));
    }

    @GetMapping("/findByDirector")
    public ResponseEntity<List<MovieDto>> getByDirector(@RequestParam String director){
        return ResponseEntity.ok(MovieMapper.INSTANCE.toDtos(movieService.findByDirector(director)));
    }

    @GetMapping("/findByActor")
    public ResponseEntity<List<MovieDto>> getByActor(@RequestParam String actor){
        return ResponseEntity.ok(MovieMapper.INSTANCE.toDtos(movieService.findByActor(actor)));
    }

    @GetMapping("/findByReleaseDate")
    public ResponseEntity<List<MovieDto>> getByReleaseDate(@RequestParam String fromDate , String toDate){
        return ResponseEntity.ok(MovieMapper.INSTANCE.toDtos(movieService.findByReleaseDateBetween(fromDate,toDate)));
    }

}

