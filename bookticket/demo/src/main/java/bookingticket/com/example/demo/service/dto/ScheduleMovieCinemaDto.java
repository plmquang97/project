package bookingticket.com.example.demo.service.dto;

import bookingticket.com.example.demo.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleMovieCinemaDto {
    private String cinemaName;
    private String movie;

}
