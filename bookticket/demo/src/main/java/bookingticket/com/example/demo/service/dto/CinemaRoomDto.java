package bookingticket.com.example.demo.service.dto;

import bookingticket.com.example.demo.entities.Cinema;
import bookingticket.com.example.demo.entities.CinemaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaRoomDto {
    private Integer maximumSeat;

    private CinemaType cinemaType;

    private Cinema cinema;
}
