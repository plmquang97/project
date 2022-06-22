package bookingticket.com.example.demo.service.mapper;

import bookingticket.com.example.demo.entities.Booking;
import bookingticket.com.example.demo.service.dto.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);
@Mapping(source = "customer.customerId", target = "customerId")

    BookingDto toDto(Booking booking);
    List<BookingDto> toDtos(List<Booking>bookings);
}
