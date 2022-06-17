package carService.service.CarHairService;

import carService.converter.CarRentalAndReservationConverter;
import carService.converter.mapper.UpdateCarRentalMapper;
import carService.dto.entity.carHairService.UpdateCarRentalDTO;
import carService.dto.entity.carHairService.car.DescriptionCarDTO;
import carService.dto.entity.carHairService.carHairService.CarRentalByCompanyDTO;
import carService.entity.CarHairService.CarRental;
import carService.repository.CarHairService.CarRentalRepository;
import carService.service.car.DescriptionCarService;
import carService.service.customer.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarRentalService {

    private final CarRentalRepository carRentalRepository;
    private final DescriptionCarService descriptionCarService;

    private final UpdateCarRentalMapper updateCarRentalMapper = UpdateCarRentalMapper.INSTANCE;
    CarRentalAndReservationConverter converter = new CarRentalAndReservationConverter();

    @Autowired
    public CarRentalService(CarRentalRepository carRentalRepository,
                            DescriptionCarService descriptionCarService) {
        this.carRentalRepository = carRentalRepository;
        this.descriptionCarService = descriptionCarService;
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

    @Transactional
    public List<CarRentalByCompanyDTO> getAllByCompIdAndUserId(Long companyId, Long userId) {
        List<CarRentalByCompanyDTO> carRentalByCompanyDTOS = new LinkedList<>();
        List<DescriptionCarDTO> descriptionCarDTOS = descriptionCarService.getAllByCompanyId(companyId);
        List<CarRental> carRentals = carRentalRepository.findAllByCompanyIdAndUserId(companyId, userId);
        for (CarRental modRental : carRentals) {
            CarRentalByCompanyDTO newListCarAndRental = new CarRentalByCompanyDTO();
            for (DescriptionCarDTO mod : descriptionCarDTOS) {
                if (modRental.getDescriptionCarId() == mod.getId()) {
                    newListCarAndRental.setId(modRental.getId());
                    newListCarAndRental.setCommentsRental(modRental.getCommentsRental());
                    newListCarAndRental.setCommentsCustomer(modRental.getCommentsCustomer());
                    newListCarAndRental.setRentalDate(modRental.getRentalDate());
                    newListCarAndRental.setUserId(modRental.getUserId());
                    newListCarAndRental.setDescriptionCarId(mod.getId());
                    newListCarAndRental.setCarBrand(mod.getCarBrand());
                    newListCarAndRental.setCarType(mod.getCarType());
                    newListCarAndRental.setModel(mod.getModel());
                    carRentalByCompanyDTOS.add(newListCarAndRental);
                    break;

                }
            }
        }
        return carRentalByCompanyDTOS;
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
