package bookingticket.com.example.demo.service.dto;

import bookingticket.com.example.demo.entities.Cinema;
import bookingticket.com.example.demo.entities.CinemaRoom;
import bookingticket.com.example.demo.entities.SeatStatus;
import bookingticket.com.example.demo.entities.SeatingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatsDto {

    private Integer seatPrice;

    private String seatNumber;

    private SeatStatus seatStatus;

    private SeatingType seatingType;

    private CinemaRoom cinemaRoom;

}
