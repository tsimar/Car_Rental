package carService.service.customer;


import carService.converter.mapper.user.UserByCompanyConverter;
import carService.converter.mapper.user.UserCustomerToCustomer_UserConverter;
import carService.dto.entity.carHairService.user.UserByCompaniesDTO;
import carService.dto.entity.carHairService.user.User_CustomerDTO;
import carService.entity.Customer.User;
import carService.entity.Customer.UserToDepartment;
import carService.repository.Customer.UserIdByDepartmentIdRepository;
import carService.repository.Customer.UserRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter

public class UserService {
    private final UserRepository userRepository;
    private final UserIdByDepartmentIdRepository userIdByDepartmentIdRepository;
    private final CustomerInfoService customerInfoService;
    private final UserToDepartmentService userToDepartmentService;

    public UserService(UserRepository userRepository, UserIdByDepartmentIdRepository userToDepartmentRepository, CustomerInfoService customerInfoService, UserToDepartmentService userToDepartmentService) {
        this.userRepository = userRepository;
        this.userIdByDepartmentIdRepository = userToDepartmentRepository;
        this.customerInfoService = customerInfoService;
        this.userToDepartmentService = userToDepartmentService;
    }

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public List<UserByCompaniesDTO> getALLUserByCompanyId(long companyId) {
        UserByCompanyConverter userConverter = new UserByCompanyConverter();
        List<UserToDepartment> users = new ArrayList<>();
        try {
            users = userIdByDepartmentIdRepository.findUsersIdByDepartmentId(companyId);
        } catch (Exception e) {
            System.out.println(e);
        }
                List<User> allUsers = findAll();
        return userConverter.userByCompanyDTOS(users, allUsers);
    }

    public List<User> getUser(String user) {
        return userRepository.findUser(user);
    }

    public User save(User_CustomerDTO newUser) {
        UserCustomerToCustomer_UserConverter customer = new UserCustomerToCustomer_UserConverter();
        User user = userRepository.save(customer.saveUser(newUser));
        userToDepartmentService.saveUserIdDepartmentId(user.getDepartmentId(), user.getId());
        customerInfoService.saveCustomer(customer.saveCustomer(newUser, user.getId()));
        return null;

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

    public User loginUser(String name, String password) {
        User user1 = new User();
        user1.setUserName(name);

        User getUser = (userRepository.loginUser(name, password));
        if (getUser == null) {
            user1.setUserName("non good login or don't password");
            return user1;
        }
        return getUser;
    }
}
