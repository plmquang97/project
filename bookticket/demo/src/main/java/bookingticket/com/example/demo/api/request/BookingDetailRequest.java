package bookingticket.com.example.demo.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetailRequest {
    private Integer bookingId;

    private Integer scheduleId;

    private Integer seatsId;
}

