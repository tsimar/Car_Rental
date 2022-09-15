package carService.entity.Customer;

import carService.entity.CarHairService.Reservation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCustomer;
    private String lastNameCustomer;
    private String email;
    private String address;
       private long reservationId;
    private long userId;


}
