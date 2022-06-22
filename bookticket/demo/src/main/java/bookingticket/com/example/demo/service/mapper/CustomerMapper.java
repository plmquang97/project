package bookingticket.com.example.demo.service.mapper;
import bookingticket.com.example.demo.entities.Customer;
import bookingticket.com.example.demo.service.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
   CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto toDto(Customer customer);
    List<CustomerDto> toDtos(List<Customer> customers);
}
