package bookingticket.com.example.demo.service.impl;

import bookingticket.com.example.demo.api.request.CinemaRequest;
import bookingticket.com.example.demo.entities.Cinema;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.repositories.CinemaRepository;
import bookingticket.com.example.demo.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema saveCinema(CinemaRequest cinemaRequest) {
        Cinema newCinema = new Cinema();
        newCinema.setCinemaName(cinemaRequest.getCinemaName());
        newCinema.setAddress(cinemaRequest.getAddress());
        newCinema.setPhoneNumber(cinemaRequest.getPhoneNumber());
        return cinemaRepository.save(newCinema);
    }

    @Override
    public Optional<Cinema> findCinemaById(Integer id) {
        return cinemaRepository.findById(id);
    }

    @Override
    public void deleteCinemaById(Integer id) {
        cinemaRepository.deleteById(id);
    }

    @Override
    public Cinema update(Integer id, CinemaRequest cinemaRequest) throws ResourceNotFoundException {
        Cinema editCinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cinema id not found: " + id));
        editCinema.setCinemaName(cinemaRequest.getCinemaName());
        editCinema.setAddress(cinemaRequest.getAddress());
        editCinema.setPhoneNumber(cinemaRequest.getPhoneNumber());
        return cinemaRepository.save(editCinema);
    }
}
