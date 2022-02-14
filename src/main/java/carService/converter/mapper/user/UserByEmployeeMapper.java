package carService.converter.mapper.user;

import carService.dto.entity.carHairService.user.UserByEmployeeDTO;
import carService.entity.Car.Employee;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface UserByEmployeeMapper {
    UserByEmployeeMapper INSTANCE= Mappers.getMapper(UserByEmployeeMapper.class);
    List<UserByEmployeeDTO> toDto (List<Employee> entity);
    List<Employee> toEntity (List<UserByEmployeeDTO> dto);
}
