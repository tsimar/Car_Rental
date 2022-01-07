package carService.dto.entity.carHairService.car;

import lombok.Data;

import java.util.Date;

@Data
public class DescriptionCarDTO {


    private Long id;
    private String carBrand;
    private String model;
    private String carType;
    private Date productionDate;
    private String color;
    private double carMileage;
    private String statusRental;
    private String carStatus;
    private Long carRentalDepartID;
}
