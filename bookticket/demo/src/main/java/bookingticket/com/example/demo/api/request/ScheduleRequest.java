package bookingticket.com.example.demo.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequest {

    private Integer cinemaId;

    private Integer movieId;

    private LocalTime startTime;

    private LocalDate startDate;
}
