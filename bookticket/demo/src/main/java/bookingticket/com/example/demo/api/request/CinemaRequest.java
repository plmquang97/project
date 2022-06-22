package bookingticket.com.example.demo.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaRequest {
    @NotNull
    private String cinemaName;
    @NotNull
    private String address;
    @NotNull
    private String phoneNumber;
}
