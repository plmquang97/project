package bookingticket.com.example.demo.api.request;

import bookingticket.com.example.demo.entities.AgeRestriction;
import bookingticket.com.example.demo.entities.MovieGenre;
import bookingticket.com.example.demo.entities.MovieStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

    private String language;

    private String name;

    private String director;

    private String actor;

    private Integer length;

    private LocalDate releaseDate;

    private AgeRestriction ageRestriction;

    private MovieGenre movieGenre;

    private MovieStatus movieStatus;



}
