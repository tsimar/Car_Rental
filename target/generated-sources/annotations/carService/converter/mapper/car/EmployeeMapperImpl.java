package carService.converter.mapper.car;

import carService.dto.entity.carHairService.car.EmployeeDTO;
import carService.entity.Car.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-17T21:25:04+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public List<EmployeeDTO> toDto(List<Employee> entity) {
        if ( entity == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( entity.size() );
        for ( Employee employee : entity ) {
            list.add( employeeToEmployeeDTO( employee ) );
        }

        return list;
    }

    @Override
    public List<Employee> toEntity(List<EmployeeDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( dto.size() );
        for ( EmployeeDTO employeeDTO : dto ) {
            list.add( employeeDTOToEmployee( employeeDTO ) );
        }

        return list;
    }

    protected EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( employee.getId() );
        employeeDTO.setName( employee.getName() );
        employeeDTO.setLastName( employee.getLastName() );
        employeeDTO.setPosition( employee.getPosition() );
        employeeDTO.setCarRentalDepartID( employee.getCarRentalDepartID() );
        employeeDTO.setUserID( employee.getUserID() );

        return employeeDTO;
    }

    protected Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDTO.getId() );
        employee.setName( employeeDTO.getName() );
        employee.setLastName( employeeDTO.getLastName() );
        employee.setPosition( employeeDTO.getPosition() );
        employee.setCarRentalDepartID( employeeDTO.getCarRentalDepartID() );
        employee.setUserID( employeeDTO.getUserID() );

        return employee;
    }
}
