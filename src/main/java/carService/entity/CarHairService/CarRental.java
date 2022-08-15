package carService.entity.CarHairService;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class CarRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Long userId;
    private Long companyId;
    private Long descriptionCarId;

    private Date rentalDate;
    private String commentsRental;
    private String commentsCustomer;





}
