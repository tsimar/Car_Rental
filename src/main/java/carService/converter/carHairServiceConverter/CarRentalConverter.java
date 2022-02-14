package carService.converter.carHairServiceConverter;

import carService.dto.entity.carHairService.CarRentalDTO;
import carService.dto.entity.carHairService.carHairService.CarRentalByCompanyDTO;
import carService.entity.CarHairService.CarRental;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CarRentalConverter {
    public List<CarRentalByCompanyDTO> carRentalByCompanyDTOS(List<CarRental> carRentals, Long companyId){


        List<CarRentalByCompanyDTO> carRentalByCompanyDTOS = new LinkedList<>();


        return carRentalByCompanyDTOS;
    }
}
