package carService.converter.mapper.user;

import carService.dto.entity.carHairService.user.UserByCompaniesDTO;
import carService.entity.CarHairService.CarRental;
import carService.entity.Customer.User;
import carService.entity.Customer.UserToDepartment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Component
public class UserByCompanyConverter {

    @Transactional
    public List<UserByCompaniesDTO> userByCompanyDTOS(List<UserToDepartment> userToDepartments, List<User> users) {
        List<UserByCompaniesDTO> userByCompaniesDTOS = new LinkedList<>();
        for (User modUser : users) {
            UserByCompaniesDTO newUser = new UserByCompaniesDTO();
            for (UserToDepartment items : userToDepartments) {
                if (items.getUserId() == modUser.getId()) {
                    newUser.setId(modUser.getId());
                    newUser.setUserName(modUser.getUserName());
                    newUser.setUserPassword(modUser.getUserPassword());
                    userByCompaniesDTOS.add(newUser);
                    break;

                }
            }

        }
        return userByCompaniesDTOS;
    }
}
