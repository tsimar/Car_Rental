package carService.converter.mapper.car;

import carService.dto.entity.carHairService.car.EmployeeDTO;
import carService.entity.Car.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE= Mappers.getMapper(EmployeeMapper.class);
    List<EmployeeDTO> toDto(List<Employee> entity);
    List<Employee>toEntity(List<EmployeeDTO> dto);
}
