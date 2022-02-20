package carService.dto.entity.carHairService.carHairService;

import lombok.Data;

import java.util.Date;

@Data
public class CarReturnByCompanyDTO {
    private Long id;
        private Long userId;
    private Long companyId;
    private Date returnDate;
    private String commentsReturn;
    private String commentsCustomer;
    private double supplement;
}
