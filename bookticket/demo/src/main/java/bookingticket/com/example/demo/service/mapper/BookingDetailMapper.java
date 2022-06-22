package bookingticket.com.example.demo.service.mapper;


import bookingticket.com.example.demo.entities.BookingDetail;
import bookingticket.com.example.demo.service.dto.BookingDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookingDetailMapper {
    BookingDetailMapper INSTANCE = Mappers.getMapper(BookingDetailMapper.class);

    @Mapping(source = "schedule.startDate", target = "startDate")
    @Mapping(source = "schedule.startTime", target = "startTime")
    @Mapping(source = "schedule.movie.ageRestriction", target = "ageRestriction")
    @Mapping(source = "schedule.movie.name", target = "movieName")
    @Mapping(source = "schedule.movie.language", target = "language")

    @Mapping(source = "seats.cinemaRoom.cinema.cinemaName", target = "cinemaName")
    @Mapping(source = "seats.seatNumber", target = "seatNumber")
    @Mapping(source = "seats.seatingType", target = "seatingType")
    @Mapping(source = "seats.seatPrice", target = "seatPrice")
    BookingDetailDto toDto(BookingDetail bookingDetail);

    List<BookingDetailDto> toDtos(List<BookingDetail> bookingDetails);
}
