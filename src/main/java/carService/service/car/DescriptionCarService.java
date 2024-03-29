package carService.service.car;

import carService.converter.mapper.car.DescriptionCarMapper;
import carService.dto.entity.carHairService.car.DescriptionCarDTO;
import carService.entity.Car.DescriptionCar;
import carService.repository.car.DescriptionCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DescriptionCarService {
    private final DescriptionCarRepository descriptionCarRepository;
    DescriptionCarDTO descriptionCarDTO;
    private final DescriptionCarMapper descriptionCarMapper = DescriptionCarMapper.INSTANCE;




    public List<DescriptionCarDTO> getAllByCompanyId(Long companyId) {
        try {
            return descriptionCarMapper.toDto(descriptionCarRepository.findAllByIdCompany(companyId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

    public List<DescriptionCarDTO> getAll() {
        List<DescriptionCarDTO> testi=descriptionCarMapper.toDto(descriptionCarRepository.findAll());
        return testi;

    }

    public DescriptionCar save(DescriptionCar descriptionCar) {
        if (descriptionCar.getCarRentalDepartID() == null) {
            return null;
        }
        return descriptionCarRepository.save(descriptionCar);
    }

    public void deleteCar(Long id) {
        descriptionCarRepository.deleteById(id);
    }

    public void editCar(DescriptionCar descriptionCar) {
        descriptionCarRepository.update
                (
                        descriptionCar.getCarBrand(),
                        descriptionCar.getModel(),
                        descriptionCar.getCarType(),
                        descriptionCar.getProductionDate(),
                        descriptionCar.getColor(),
                        descriptionCar.getCarMileage(),
                        descriptionCar.getStatusRental(),
                        descriptionCar.getCarStatus(),
                        descriptionCar.getId()
                );
    }

}
