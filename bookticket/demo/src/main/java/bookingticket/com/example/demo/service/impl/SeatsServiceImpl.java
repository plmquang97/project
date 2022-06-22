package bookingticket.com.example.demo.service.impl;

import bookingticket.com.example.demo.api.request.SeatsRequest;
import bookingticket.com.example.demo.entities.CinemaType;
import bookingticket.com.example.demo.entities.SeatingType;
import bookingticket.com.example.demo.entities.Seats;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.repositories.SeatsRepository;
import bookingticket.com.example.demo.service.SeatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor

public class SeatsServiceImpl implements SeatsService {

    private final SeatsRepository seatsRepository;

    @Override
    public List<Seats> getAll() {
        return seatsRepository.findAll();
    }

    @Override
    public Seats saveSeats(SeatsRequest seatsRequest) {
        Seats newSeats = new Seats();
        newSeats.setSeatPrice(seatsRequest.getSeatPrice());
        newSeats.setSeatNumber(seatsRequest.getSeatNumber());
        newSeats.setSeatingType(seatsRequest.getSeatingType());
        newSeats.setSeatStatus(seatsRequest.getSeatStatus());
        newSeats.setCinemaRoom(seatsRequest.getCinemaRoom());
        return seatsRepository.save(newSeats);
    }

    @Override
    public Optional<Seats> findSeatsById(Integer id) {
        return seatsRepository.findById(id);
    }

    @Override
    public void deleteSeatsById(Integer id) {
        seatsRepository.deleteById(id);
    }

    @Override
    public Seats update(Integer id, SeatsRequest seatsRequest) throws ResourceNotFoundException {
        Seats editSeats = seatsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule id not found : " + id));
        editSeats.setSeatPrice(seatsRequest.getSeatPrice());
        editSeats.setSeatNumber(seatsRequest.getSeatNumber());
        editSeats.setSeatingType(seatsRequest.getSeatingType());
        editSeats.setSeatStatus(seatsRequest.getSeatStatus());
        editSeats.setCinemaRoom(seatsRequest.getCinemaRoom());
        return seatsRepository.save(editSeats);
    }



    @Override
    public List<Seats> findBySeatingTypeAndCinemaType(String seatingType, String cinemaType) {
        return seatsRepository.getSeatBySeatingTypeAndCinemaRoomType(SeatingType.valueOf(seatingType),CinemaType.valueOf(cinemaType));
    }
}
