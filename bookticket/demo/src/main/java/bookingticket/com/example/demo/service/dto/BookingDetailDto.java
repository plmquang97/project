package bookingticket.com.example.demo.service.dto;

import bookingticket.com.example.demo.entities.AgeRestriction;

import bookingticket.com.example.demo.entities.SeatingType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetailDto {

    private LocalDate startDate;

    private LocalTime startTime;

    private AgeRestriction ageRestriction;

    private String movieName;

    private String language;

    private String cinemaName;

    private SeatingType seatingType;

    private String seatNumber;

    private Integer seatPrice;








}
