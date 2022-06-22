package bookingticket.com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerAccountId;

    @Size(min =5)
    private String userName;

    @Size(min = 5)
    private String passWord;

    @ManyToOne
    @JoinColumn
    private Customer customer;
}
