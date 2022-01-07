package carService.service.car;

import carService.converter.mapper.car.EmployeeMapper;
import carService.dto.entity.carHairService.car.EmployeeDTO;
import carService.entity.Car.Employee;
import carService.repository.car.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;


    public List<EmployeeDTO> getAll() {
        return employeeMapper.toDto(employeeRepository.findAll());
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteCar(Long id) {
        employeeRepository.deleteById(id);
    }

    public void editCar(Employee employee) {
        employeeRepository.update
                (
                        employee.getName(),
                        employee.getLastName(),
                        employee.getPosition(),
                        employee.getId()

                );
    }

}
