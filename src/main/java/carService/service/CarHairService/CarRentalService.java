package carService.service.CarHairService;

import carService.converter.CarRentalAndReservationConverter;
import carService.converter.mapper.UpdateCarRentalMapper;
import carService.dto.entity.carHairService.UpdateCarRentalDTO;
import carService.entity.CarHairService.CarRental;
import carService.repository.CarHairService.CarRentalRepository;
import carService.service.customer.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarRentalService {

    private final CarRentalRepository carRentalRepository;


    private final UpdateCarRentalMapper updateCarRentalMapper = UpdateCarRentalMapper.INSTANCE;
    CarRentalAndReservationConverter converter = new CarRentalAndReservationConverter();

    @Autowired
    public CarRentalService(CarRentalRepository carRentalRepository) {
        this.carRentalRepository = carRentalRepository;


    }



    @Transactional
    public CarRental save(CarRental newCarRental) {
        carRentalRepository.save(newCarRental);
        return carRentalRepository.save(newCarRental);
    }

    @Transactional
    public List<CarRental> getAll() {
        return carRentalRepository.findAll();
    }


    public List<CarRental> getAllByCompIdAndUserId(Long companyId, Long userId) {

        return carRentalRepository.findAllByCompanyIdAndUserId(companyId, userId);
    }
    public List<CarRental> getAllByCompId(Long companyId) {

        return carRentalRepository.findAllByCompanyId(companyId);
    }

    public CarRental editCarRental(CarRental carRentalDetails) {

        UpdateCarRentalDTO updateCarRentalDTO = updateCarRentalMapper.toDto(carRentalDetails);
        CarRental carRental = updateCarRentalMapper.toEntity(updateCarRentalDTO);

        return carRentalRepository.save(carRental);
    }


    public List<CarRental> deleteCarRental(Long id) {

        carRentalRepository.deleteById(id);

        return carRentalRepository.findAll();
    }
}
