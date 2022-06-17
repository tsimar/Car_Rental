package carService.service.customer;


import carService.converter.mapper.user.UserByCompanyConverter;
import carService.dto.entity.carHairService.user.UserByCompaniesDTO;
import carService.entity.CarHairService.CarRental;
import carService.entity.Customer.User;
import carService.entity.Customer.UserToDepartment;
import carService.repository.Customer.UserRepository;
import carService.repository.Customer.UserToDepartmentRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Getter

public class UserService {
    private final UserRepository userRepository;
    private final UserToDepartmentRepository userToDepartmentRepository;

    public UserService(UserRepository userRepository, UserToDepartmentRepository userToDepartmentRepository) {
        this.userRepository = userRepository;
        this.userToDepartmentRepository = userToDepartmentRepository;

    }

    public List<User> findAll() {
        return getUserRepository().findAll();
    }

    public List<UserByCompaniesDTO> getALLUserByCompanyId(Long companyId) {
        UserByCompanyConverter userConverter = new UserByCompanyConverter();
        List<UserToDepartment> users = userToDepartmentRepository.findUsersIdByDepartmentId(companyId);
        List<User> allUsers = findAll();
        return userConverter.userByCompanyDTOS(users, allUsers);
    }

    public User save(User newUser) {

        return userRepository.save(newUser);


        //hashuje haslo za pomocą Beana w klasie SecurityConfig


    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    public void editUser(User user) {
        try {
            userRepository.update
                    (
                            user.getUserName(),
                            user.getUserPassword(),
                            user.getId()
                    );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
