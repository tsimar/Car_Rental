package carService.converter.mapper.user;

import carService.converter.mapper.UpdateCarRentalMapper;
import carService.dto.entity.carHairService.user.UserByCompaniesDTO;
import carService.entity.Car.CarRentalDepartment;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface UserByCompaniesMapper {
    UserByCompaniesMapper INSTANCE= Mappers.getMapper(UserByCompaniesMapper.class);
   List <UserByCompaniesDTO> toDto(List<CarRentalDepartment> entity);
    List<CarRentalDepartment> toEntity(List<UserByCompaniesDTO >dto);
}
