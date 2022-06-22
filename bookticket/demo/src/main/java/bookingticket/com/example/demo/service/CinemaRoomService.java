package bookingticket.com.example.demo.service;


import bookingticket.com.example.demo.api.request.CinemaRoomRequest;
import bookingticket.com.example.demo.entities.CinemaRoom;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CinemaRoomService {
    List<CinemaRoom> getAll();

    CinemaRoom saveCinemaRoom(CinemaRoomRequest cinemaRoom);

    Optional<CinemaRoom> findCinemaRoomById(Integer id);

    void deleteCinemaRoomById(Integer id);

    CinemaRoom update (Integer id, CinemaRoomRequest cinemaRoomRequest)throws ResourceNotFoundException;
}
