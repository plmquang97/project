package bookingticket.com.example.demo.service.dto;

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
public class MovieDto {

    private String name;

    private String director;

    private String actor;

    private MovieGenre movieGenre;

    private LocalDate releaseDate;

    private Integer length;

    private String language;

    private AgeRestriction ageRestriction;

    private MovieStatus movieStatus;












}
