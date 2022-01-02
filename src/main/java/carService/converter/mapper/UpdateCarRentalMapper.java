package carService.converter.mapper;

import carService.dto.entity.carHairService.UpdateCarRentalDTO;
import carService.entity.CarHairService.CarRental;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UpdateCarRentalMapper {
    UpdateCarRentalMapper INSTANCE= Mappers.getMapper(UpdateCarRentalMapper.class);
    UpdateCarRentalDTO toDto(CarRental entity);
    CarRental toEntity(UpdateCarRentalDTO dto);
}
