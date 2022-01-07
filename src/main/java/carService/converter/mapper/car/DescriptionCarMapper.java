package carService.converter.mapper.car;


import carService.dto.entity.carHairService.car.CarDepartMainDTO;
import carService.dto.entity.carHairService.car.DescriptionCarDTO;
import carService.entity.Car.CarRentalDepartment;
import carService.entity.Car.DescriptionCar;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DescriptionCarMapper {
    DescriptionCarMapper INSTANCE= Mappers.getMapper(DescriptionCarMapper.class);
    List<DescriptionCarDTO> toDto(List<DescriptionCar> entity);
    List<DescriptionCar>toEntity(List<DescriptionCarDTO> dto);
}
