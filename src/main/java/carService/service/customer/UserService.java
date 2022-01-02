package carService.service.customer;


import carService.entity.Customer.User;
import carService.repository.Customer.UserRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter

public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public List<User> findAll() {
        return getUserRepository().findAll();
    }

//@Transactional
    public User save(User newUser) {
//        if (newUser.getCustomer() != null) {
//            userRepository.save(newUser);
//
//            for (Customer mod : newUser.getCustomer()) {
//                mod.setUser(newUser);
//                customerRepository.save(mod);
//            }
            return userRepository.save(newUser);
//        } else {
//            return null;
//        }


        //hashuje haslo za pomocą Beana w klasie SecurityConfig


    }

    public void deleteUser(Long id) {
       userRepository.deleteById(id);

    }

    public void editUser(User user) {
        try{
            userRepository.update
                    (
                            user.getUserName(),
                            user.getUserPassword(),
                            user.getId()
                    );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
