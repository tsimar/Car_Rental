package carService.service.customer;


import carService.converter.mapper.user.UserByCompanyConverter;
import carService.converter.mapper.user.UserCustomerToCustomer_UserConverter;
import carService.dto.entity.carHairService.user.UserByCompaniesDTO;
import carService.dto.entity.carHairService.user.User_CustomerDTO;
import carService.entity.Customer.Customer;
import carService.entity.Customer.User;
import carService.entity.Customer.UserToDepartment;
import carService.repository.Customer.CustomerInfoRepository;
import carService.repository.Customer.UserRepository;
import carService.repository.Customer.UserIdByDepartmentIdRepository;
import lombok.Getter;
import org.hibernate.collection.internal.PersistentList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter

public class UserService {
    private final UserRepository userRepository;
    private final UserIdByDepartmentIdRepository userIdByDepartmentIdRepository;
    private final CustomerInfoService customerInfoService;


    public UserService(UserRepository userRepository, UserIdByDepartmentIdRepository userToDepartmentRepository, CustomerInfoService customerInfoService) {
        this.userRepository = userRepository;
        this.userIdByDepartmentIdRepository = userToDepartmentRepository;
        this.customerInfoService = customerInfoService;
    }

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public List<UserByCompaniesDTO> getALLUserByCompanyId(int companyId) {
        UserByCompanyConverter userConverter = new UserByCompanyConverter();
        List<UserToDepartment> users = new ArrayList<>();
        users = userIdByDepartmentIdRepository.findUsersIdByDepartmentId(companyId);
        List<User> allUsers = findAll();
        return userConverter.userByCompanyDTOS(users, allUsers);
    }

    public List<User> getUser(String user) {
        return userRepository.findUser(user);
    }

    public User save(User_CustomerDTO newUser) {
        UserCustomerToCustomer_UserConverter customer = new UserCustomerToCustomer_UserConverter();
        customerInfoService.saveCustomer(customer.saveCustomer(newUser));
        return userRepository.save(customer.saveUser(newUser));

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
