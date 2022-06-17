package carService.entity.Car;


import carService.entity.CarHairService.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
public class CarRentalDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String logo;
    private String nameRental;
    private String city;
    private String address;

    private int userId;
    @ManyToOne
    @JoinColumn(name = "reservation_rental_id")
    @JsonIgnore
    private Reservation reservationRental;

    @ManyToOne
    @JoinColumn(name = "reservation_return_id")
    private Reservation reservationReturn;


}
