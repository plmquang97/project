package bookingticket.com.example.demo.service.impl;


import bookingticket.com.example.demo.api.request.CinemaRoomRequest;
import bookingticket.com.example.demo.entities.CinemaRoom;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.repositories.CinemaRoomRepository;
import bookingticket.com.example.demo.service.CinemaRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CinemaRoomServiceImpl implements CinemaRoomService {

    private final CinemaRoomRepository cinemaRoomRepository;

    @Override
    public List<CinemaRoom> getAll() {
        return cinemaRoomRepository.findAll();
    }

    @Override
    public CinemaRoom saveCinemaRoom(CinemaRoomRequest cinemaRoomRequest) {
        CinemaRoom newCinemaRoom = new CinemaRoom();
        newCinemaRoom.setCinemaType(cinemaRoomRequest.getCinemaType());
        newCinemaRoom.setMaximumSeat(cinemaRoomRequest.getMaximumSeat());
        newCinemaRoom.setCinema(cinemaRoomRequest.getCinema());
        return cinemaRoomRepository.save(newCinemaRoom);
    }

    @Override
    public Optional<CinemaRoom> findCinemaRoomById(Integer id) {
        return cinemaRoomRepository.findById(id);
    }

    @Override
    public void deleteCinemaRoomById(Integer id) {
        cinemaRoomRepository.deleteById(id);
    }

    @Override
    public CinemaRoom update(Integer id, CinemaRoomRequest cinemaRoomRequest) throws ResourceNotFoundException {
        CinemaRoom editCinemaRoom = cinemaRoomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CinemaRoom id not found : " + id));
        editCinemaRoom.setMaximumSeat(cinemaRoomRequest.getMaximumSeat());
        editCinemaRoom.setCinemaType(cinemaRoomRequest.getCinemaType());
        editCinemaRoom.setCinema(cinemaRoomRequest.getCinema());
        return cinemaRoomRepository.save(editCinemaRoom);
    }
}
