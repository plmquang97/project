package bookingticket.com.example.demo.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    @NotNull
    private String customerName;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String email;
    @NotNull
    private LocalDate birthDay;
}
