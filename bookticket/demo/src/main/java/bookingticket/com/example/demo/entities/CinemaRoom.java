package bookingticket.com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class CinemaRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cinemaRoomId;

    private Integer maximumSeat;

    @Enumerated(EnumType.STRING)
    private CinemaType cinemaType;

    @ManyToOne
    @JoinColumn
    private Cinema cinema;

}
