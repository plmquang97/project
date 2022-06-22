package bookingticket.com.example.demo.service.mapper;

import bookingticket.com.example.demo.entities.CinemaRoom;
import bookingticket.com.example.demo.service.dto.CinemaRoomDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CinemaRoomMapper {
   CinemaRoomMapper INSTANCE = Mappers.getMapper(CinemaRoomMapper.class);

    CinemaRoomDto toDto(CinemaRoom cinemaRoom);
    List<CinemaRoomDto> toDtos(List<CinemaRoom>cinemaRooms);
}
