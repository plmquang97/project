package bookingticket.com.example.demo.service.dto;

import bookingticket.com.example.demo.entities.Customer;
import bookingticket.com.example.demo.entities.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private Integer bookingId;

    private LocalDate paymentDate;

    private double totalPrice;

    private PaymentType paymentType;

    private Integer customerId;

    private List<BookingDetailDto> bookingDetailDtos;

}
