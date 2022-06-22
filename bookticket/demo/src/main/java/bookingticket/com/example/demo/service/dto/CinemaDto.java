package bookingticket.com.example.demo.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDto {

    private String cinemaName;

    private String address;

    private String phoneNumber;
}
