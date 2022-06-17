package carService.entity.Car;


import carService.entity.CarHairService.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class DescriptionCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carBrand;
    private String model;
    private String carType;
    private Date productionDate;
    private String color;
    private int carMileage;
    private String statusRental;
    private String carStatus;
    private Long carRentalDepartID;
    private String carNumber;

    public Long getId() {
        return id;
    }

    @ManyToOne
    private Reservation reservation;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "descriptionCar")
    private List<RentalsAmountCar> rentalsAmountCarList;


//    @ManyToOne
//    @JoinColumn(name = "car_rental_department_description_id")
//    private CarRentalDepartment carRentalDepartment;
}
