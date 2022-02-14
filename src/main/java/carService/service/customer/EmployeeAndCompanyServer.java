package carService.service.customer;

import carService.converter.mapper.user.UserByCompanyConverter;
import carService.dto.entity.carHairService.user.EmployeeAndCompanyDTO;
import carService.repository.car.CarRentalDepartmentRepository;
import carService.repository.car.EmployeeRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter

public class EmployeeAndCompanyServer {
    private  final CarRentalDepartmentRepository carRentalDepartmentRepository;
    private final EmployeeRepository employeeRepository;

UserByCompanyConverter companyConverter= new UserByCompanyConverter();

    public EmployeeAndCompanyServer(CarRentalDepartmentRepository carRentalDepartmentRepository, EmployeeRepository employeeRepository){
        this.carRentalDepartmentRepository=carRentalDepartmentRepository;
        this.employeeRepository=employeeRepository;
    }
//    public List<EmployeeAndCompanyDTO> getALLCompany(){
//        return companyConverter.employeeAndCompanyDTOS(employeeRepository.findAll(),carRentalDepartmentRepository.findAll());
//    }


}
