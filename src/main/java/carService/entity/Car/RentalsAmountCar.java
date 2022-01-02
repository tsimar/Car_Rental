package carService.entity.Car;


import carService.entity.CarHairService.Reservation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor

public class RentalsAmountCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "description_car_id")
    private DescriptionCar descriptionCar;
}
