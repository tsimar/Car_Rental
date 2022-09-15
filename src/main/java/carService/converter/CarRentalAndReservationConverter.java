package carService.converter;

import carService.dto.entity.carHairService.CarRentalDTO;
import carService.dto.entity.carHairService.ReservationDTO;
import carService.entity.CarHairService.CarRental;
import carService.entity.CarHairService.Reservation;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Component

public class CarRentalAndReservationConverter {


    @Transactional
    public List<CarRentalDTO> carRentalDTO(List<CarRental> carRentals) {

        List<CarRentalDTO> carRentalDTOS = new LinkedList<>();

        for (CarRental modCarRental : carRentals) {
            CarRentalDTO newCarRentalDTO = new CarRentalDTO();
            newCarRentalDTO.setId(modCarRental.getId());
            newCarRentalDTO.setEmployeeId(modCarRental.getEmployeeId());

            newCarRentalDTO.setRentalDate(modCarRental.getRentalDate());
            newCarRentalDTO.setCommentsRental(modCarRental.getCommentsRental());
            newCarRentalDTO.setCommentsCustomer(modCarRental.getCommentsCustomer());
            List<ReservationDTO> reservationDTOS = new ArrayList<>();
            newCarRentalDTO.setReservationDTOS(reservationDTOS);
            carRentalDTOS.add(newCarRentalDTO);
        }
        return carRentalDTOS;
    }


}
