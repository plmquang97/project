package bookingticket.com.example.demo.service;

import bookingticket.com.example.demo.api.request.MovieRequest;
import bookingticket.com.example.demo.entities.Movie;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAll();

    Movie saveMovie(MovieRequest movie);

    Optional<Movie> findMovieById(Integer id);

    void deleteMovieById(Integer id);

    Movie update(Integer id, MovieRequest movieRequest) throws ResourceNotFoundException;

    List<Movie> findByDirector(String director);

    List<Movie> findByActor(String actor);

    List<Movie> findByReleaseDateBetween(String fromDate, String toDate);


}
