package bookingticket.com.example.demo.service.mapper;
import bookingticket.com.example.demo.entities.Movie;
import bookingticket.com.example.demo.service.dto.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
  MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDto toDto(Movie movie);
    List<MovieDto> toDtos(List<Movie>movies);
}
