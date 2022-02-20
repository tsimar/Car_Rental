package carService.converter.mapper.user;

import carService.dto.entity.carHairService.user.EmployeeAndCompanyDTO;
import carService.dto.entity.carHairService.user.UserByCompaniesDTO;
import carService.entity.Car.CarRentalDepartment;
import carService.entity.Car.Employee;
import carService.entity.CarHairService.CarRental;
import carService.entity.Customer.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Component
public class UserByCompanyConverter {

    @Transactional
    public List<UserByCompaniesDTO> userByCompanyDTOS(List<CarRental> carRentals, List<User> users) {
        List<UserByCompaniesDTO> userByCompaniesDTOS = new LinkedList<>();
        for (User modUser : users) {
            UserByCompaniesDTO newUser=new UserByCompaniesDTO();
            for (CarRental modCarRental : carRentals) {
                if (modCarRental.getUserId() == modUser.getId())  {
                    newUser.setId(modUser.getId());
                    newUser.setUserName(modUser.getUserName());
                    userByCompaniesDTOS.add(newUser);
                    break;

                }
            }

        }
        return userByCompaniesDTOS;
    }
}
