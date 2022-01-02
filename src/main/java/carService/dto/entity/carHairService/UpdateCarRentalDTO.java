package carService.dto.entity.carHairService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
public class UpdateCarRentalDTO {
    private Long id;
    private Date rentalDate;
    private String commentsRental;
    private String commentsCustomer;
    private Long employeeId;

@JsonIgnore
    private List<ReservationDTO> reservationDTOS;
}
