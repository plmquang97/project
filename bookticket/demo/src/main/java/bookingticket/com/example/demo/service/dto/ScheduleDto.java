package bookingticket.com.example.demo.service.dto;

import bookingticket.com.example.demo.entities.Cinema;
import bookingticket.com.example.demo.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {

    private LocalTime startTime;

    private LocalDate startDate;

    private Integer movieId;

    private Integer cinemaId;

    private String movieName;

    private String language;

    private String cinemaName;




}
