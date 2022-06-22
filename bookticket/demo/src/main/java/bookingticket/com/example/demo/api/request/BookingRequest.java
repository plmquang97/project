package bookingticket.com.example.demo.api.request;

import bookingticket.com.example.demo.entities.BookingDetail;
import bookingticket.com.example.demo.entities.Customer;
import bookingticket.com.example.demo.entities.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    private LocalDate paymentDate;

    private double totalPrice;

    private PaymentType paymentType;

    private Customer customer;

    private List<BookingDetailRequest> bookingDetailRequests;
}
