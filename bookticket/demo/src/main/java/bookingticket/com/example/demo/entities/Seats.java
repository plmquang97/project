package bookingticket.com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    private String seatNumber;

    private Integer seatPrice;

    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

    @Enumerated(EnumType.STRING)
    private SeatingType seatingType;

    @JoinColumn
    @ManyToOne
    private CinemaRoom cinemaRoom;
}
