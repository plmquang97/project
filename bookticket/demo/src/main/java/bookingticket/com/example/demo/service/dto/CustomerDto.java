package bookingticket.com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private String customerName;

    private String phoneNumber;

    private String email;

    private LocalDate birthDay;


}
