package carService.controller.customer;


import carService.dto.entity.carHairService.user.UserByCompaniesDTO;
import carService.entity.Customer.User;
import carService.entity.Customer.UserToDepartment;
import carService.service.customer.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
           }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }


    @GetMapping("/{companyId}")
    public ResponseEntity<List<UserByCompaniesDTO>> findAllCompany(@PathVariable Long companyId) {

        return ResponseEntity.ok(userService.getALLUserByCompanyId(companyId));
    }

    @PostMapping()
    public ResponseEntity<User> newUser(@RequestBody User newUser) {

        if (newUser.getUserName() == null || newUser.getUserPassword() == null) {
            throw new RuntimeException("You must define new user");

        } else {
            return ResponseEntity.ok(userService.save(newUser));
        }
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        if (id == null) {
            throw new RuntimeException("You must define new user");
        } else {
            userService.deleteUser(id);
        }
    }

    @PutMapping()
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }

}
