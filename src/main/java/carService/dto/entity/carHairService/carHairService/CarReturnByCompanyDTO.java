package carService.dto.entity.carHairService.carHairService;

import lombok.Data;

import java.util.Date;

@Data
public class CarReturnByCompanyDTO {
    private Long id;

    private Long employeeId;
        private Long userId;
//    private Long companyId;
    private Date returnDate;
    private String commentsReturn;
    private String commentsCustomer;
    private double supplement;

    private Long descriptionCarId;
    private String carBrand;
    private String model;
    private String carType;
    private String carNumber;

}
