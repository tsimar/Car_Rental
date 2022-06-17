package carService.dto.entity.carHairService.carHairService;

import lombok.Data;

import java.util.Date;

@Data
public class CarRentalByCompanyDTO {
    private Long id;

    private Long employeeId;
    private Long userId;
    private Date rentalDate;
    private String commentsRental;
    private String commentsCustomer;

    private Long descriptionCarId;
    private String carBrand;
    private String model;
    private String carType;
    private String carNumber;
}
