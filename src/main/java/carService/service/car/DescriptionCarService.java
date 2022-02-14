package carService.service.car;

import carService.converter.mapper.car.DescriptionCarMapper;
import carService.dto.entity.carHairService.car.DescriptionCarDTO;
import carService.entity.Car.DescriptionCar;
import carService.repository.car.DescriptionCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DescriptionCarService {
    private final DescriptionCarRepository descriptionCarRepository;
    DescriptionCarDTO descriptionCarDTO;
    private final DescriptionCarMapper descriptionCarMapper = DescriptionCarMapper.INSTANCE;


    public  List<DescriptionCarDTO> getAllById(Long id){
        try{
            return descriptionCarMapper.toDto(descriptionCarRepository.findAllByIdCar(id));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

return null;

    }
    public  List<DescriptionCarDTO> getAll(){
 return descriptionCarMapper.toDto(descriptionCarRepository.findAll());

    }
    public DescriptionCar save(DescriptionCar descriptionCar){
        return descriptionCarRepository.save(descriptionCar);
    }
    public void deleteCar(Long id){
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
