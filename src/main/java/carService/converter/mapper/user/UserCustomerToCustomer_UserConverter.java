package carService.converter.mapper.user;

import carService.dto.entity.carHairService.user.User_CustomerDTO;
import carService.entity.Customer.Customer;
import carService.entity.Customer.User;
import org.springframework.stereotype.Component;

@Component
public class UserCustomerToCustomer_UserConverter {

    public User saveUser(User_CustomerDTO user_customerDTO) {
        User users = new User();
//      List<User> newUser= new ArrayList<>();
        users.setUserName(user_customerDTO.getUserName());
        users.setUserPassword(user_customerDTO.getUserPassword());

        return users;
    }

    //    public List<User_CustomerDTO> user_customerDTO=new LinkedList<>();
    public Customer saveCustomer(User_CustomerDTO user_customerDTO,long userId) {

        Customer customer = new Customer();

        customer.setNameCustomer(user_customerDTO.getNameCustomer());
        customer.setLastNameCustomer(user_customerDTO.getLastNameCustomer());
        customer.setEmail(user_customerDTO.getEmail());
        customer.setAddress(user_customerDTO.getAddress());
        customer.setUserId(userId);


        return customer;
    }

}
