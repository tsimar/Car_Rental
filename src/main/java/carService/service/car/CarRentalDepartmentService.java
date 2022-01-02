package carService.service.car;

import carService.converter.mapper.car.CarDepartMainMapper;
import carService.dto.entity.carHairService.car.CarDepartMainDTO;
import carService.entity.Car.CarRentalDepartment;
import carService.entity.Customer.User;
import carService.repository.car.CarRentalDepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarRentalDepartmentService {
    private final CarRentalDepartmentRepository carRentalDepartmentRepository;
    private final CarDepartMainMapper carDepartMainMapper = CarDepartMainMapper.INSTANCE;

    public CarRentalDepartment save (CarRentalDepartment carRentalDepartment){
        return  carRentalDepartmentRepository.save(carRentalDepartment);

    }

    public  List<CarDepartMainDTO> getAll(){
        return carDepartMainMapper.toDto(carRentalDepartmentRepository.findAll());
    }


    public void deleteCarDepart(Long id){
        carRentalDepartmentRepository.deleteById(id);
    }

    public void editCarDepart(CarRentalDepartment carRentalDepartment) {
        carRentalDepartmentRepository.update
                (
                        carRentalDepartment.getLogo(),
                        carRentalDepartment.getNameRental(),
                        carRentalDepartment.getCity(),
                        carRentalDepartment.getAddress(),
                        carRentalDepartment.getId()
                );
    }
}
