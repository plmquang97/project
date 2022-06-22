package bookingticket.com.example.demo.service.mapper;

import bookingticket.com.example.demo.entities.Schedule;
import bookingticket.com.example.demo.service.dto.ScheduleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

@Mapping(source = "movie.name",target ="movieName")
@Mapping(source = "movie.language",target ="language")
@Mapping(source = "cinema.cinemaName",target = "cinemaName")
@Mapping(source = "movie.movieId",target = "movieId")
@Mapping(source = "cinema.cinemaId",target = "cinemaId")

    ScheduleDto toDto(Schedule schedule);
    List<ScheduleDto> toDtos(List<Schedule>schedules);
}
