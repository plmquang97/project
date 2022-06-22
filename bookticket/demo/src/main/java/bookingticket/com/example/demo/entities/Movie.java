package bookingticket.com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Size (max = 20)
    private String language;

    private Integer length;

    private String name;

    private LocalDate releaseDate;

    private String director;

    private String actor;

    @Enumerated(EnumType.STRING)
    private AgeRestriction ageRestriction;

    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenre;

    @Enumerated(EnumType.STRING)
    private MovieStatus movieStatus;
}
