package carService.entity.Car;


import carService.entity.CarHairService.CarRental;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String lastName;
    private String position;

    @ManyToOne
      @JoinColumn(name = "car_rental_department_id")
    private CarRentalDepartment carRentalDepartment;

}
