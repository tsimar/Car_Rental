package carService.dto.entity.carHairService;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CarRentalDTO {
    private Long id;
    private Long employeeId;

    private Date rentalDate;
    private String commentsRental;
    private String commentsCustomer;
    private List<ReservationDTO> reservationDTOS;


}
