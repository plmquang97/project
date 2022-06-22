package bookingticket.com.example.demo.service.mapper;

import bookingticket.com.example.demo.entities.Seats;
import bookingticket.com.example.demo.service.dto.SeatsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SeatsMapper {
    SeatsMapper INSTANCE = Mappers.getMapper(SeatsMapper.class);

    SeatsDto toDto(Seats seats);
    List<SeatsDto> toDtos(List<Seats>seats);
}
