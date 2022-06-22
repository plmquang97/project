package bookingticket.com.example.demo.service.impl;

import bookingticket.com.example.demo.api.request.MovieRequest;
import bookingticket.com.example.demo.entities.Movie;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.repositories.MovieRepository;
import bookingticket.com.example.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie saveMovie(MovieRequest movieRequest) {
        Movie newMovie = new Movie();
        newMovie.setName(movieRequest.getName());
        newMovie.setLanguage(movieRequest.getLanguage());
        newMovie.setDirector(movieRequest.getDirector());
        newMovie.setActor(movieRequest.getActor());
        newMovie.setLength(movieRequest.getLength());
        newMovie.setReleaseDate(movieRequest.getReleaseDate());
        newMovie.setMovieGenre(movieRequest.getMovieGenre());
        newMovie.setMovieStatus(movieRequest.getMovieStatus());
        newMovie.setAgeRestriction(movieRequest.getAgeRestriction());
        return movieRepository.save(newMovie);
    }

    @Override
    public Optional<Movie> findMovieById(Integer id) {
        return movieRepository.findById(id);
    }

    @Override
    public void deleteMovieById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie update(Integer id, MovieRequest movieRequest) throws ResourceNotFoundException {
        Movie editMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie id not found" + id));
        editMovie.setLanguage(movieRequest.getLanguage());
        editMovie.setLength(movieRequest.getLength());
        editMovie.setName(movieRequest.getName());
        editMovie.setMovieGenre(movieRequest.getMovieGenre());
        editMovie.setAgeRestriction(movieRequest.getAgeRestriction());
        editMovie.setActor(movieRequest.getActor());
        editMovie.setDirector(movieRequest.getDirector());
        editMovie.setReleaseDate(movieRequest.getReleaseDate());
        return movieRepository.save(editMovie);
    }

    @Override
    public List<Movie> findByDirector(String director) {
        return movieRepository.findByDirectorContaining(director);
    }

    @Override
    public List<Movie> findByActor(String actor) {
        return movieRepository.findByActorContaining(actor);
    }

    @Override
    public List<Movie> findByReleaseDateBetween(String fromDate, String toDate) {
        return movieRepository.findByReleaseDateBetween(LocalDate.parse(fromDate), LocalDate.parse(toDate));
    }
}
