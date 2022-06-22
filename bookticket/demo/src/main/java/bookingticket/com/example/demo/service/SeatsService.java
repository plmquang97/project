package bookingticket.com.example.demo.service;

import bookingticket.com.example.demo.api.request.SeatsRequest;
import bookingticket.com.example.demo.entities.CinemaType;
import bookingticket.com.example.demo.entities.SeatingType;
import bookingticket.com.example.demo.entities.Seats;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface SeatsService {
    List<Seats> getAll();

    Seats saveSeats(SeatsRequest seatsRequest);

    Optional<Seats> findSeatsById(Integer id);

    void deleteSeatsById(Integer id);

    Seats update(Integer id, SeatsRequest seatsRequest) throws ResourceNotFoundException;

    List<Seats> findBySeatingTypeAndCinemaType(String seatingType, String cinemaType);
}
