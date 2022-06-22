package bookingticket.com.example.demo.service;

import bookingticket.com.example.demo.api.request.CinemaRequest;
import bookingticket.com.example.demo.entities.Cinema;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;


import java.util.List;
import java.util.Optional;

public interface CinemaService {
    List<Cinema> getAll();

    Cinema saveCinema(CinemaRequest cinema);

    Optional<Cinema> findCinemaById(Integer id);

    void deleteCinemaById(Integer id);

    Cinema update(Integer id, CinemaRequest cinemaRequest) throws ResourceNotFoundException;
}
