package bookingticket.com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailId;

    @JoinColumn
    @ManyToOne
    private Booking booking;

    @JoinColumn
    @ManyToOne
    private Schedule schedule;

    @JoinColumn
    @ManyToOne
    private Seats seats;



}
