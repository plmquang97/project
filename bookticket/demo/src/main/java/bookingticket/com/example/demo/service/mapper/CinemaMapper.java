package bookingticket.com.example.demo.service.mapper;
import bookingticket.com.example.demo.entities.Cinema;
import bookingticket.com.example.demo.service.dto.CinemaDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CinemaMapper {
  CinemaMapper INSTANCE = Mappers.getMapper(CinemaMapper.class);

    CinemaDto toDto(Cinema cinema);
    List<CinemaDto> toDtos(List<Cinema>cinemas);
}
