package bookingticket.com.example.demo.api.request;

import bookingticket.com.example.demo.entities.CinemaRoom;
import bookingticket.com.example.demo.entities.SeatStatus;
import bookingticket.com.example.demo.entities.SeatingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatsRequest {
    private String seatNumber;

    private Integer seatPrice;

    private SeatStatus seatStatus;

    private SeatingType seatingType;

    private CinemaRoom cinemaRoom;
}
