package carService.converter.mapper.car;

import carService.dto.entity.carHairService.car.CarDepartMainDTO;
import carService.entity.Car.CarRentalDepartment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarDepartMainMapper {
    CarDepartMainMapper INSTANCE= Mappers.getMapper(CarDepartMainMapper.class);
    List<CarDepartMainDTO> toDto(List<CarRentalDepartment> entity);
    List<CarRentalDepartment>toEntity(List<CarDepartMainDTO> dto);

}
