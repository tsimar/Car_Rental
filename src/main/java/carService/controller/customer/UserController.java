package carService.controller.customer;


import carService.entity.Customer.User;
import carService.service.customer.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping()
    public ResponseEntity<User> newUser(@RequestBody User newUser) {

        if (newUser.getUserName()==null || newUser.getUserPassword()==null) {
            throw new RuntimeException("You must define new user");

        } else {
            return ResponseEntity.ok(userService.save(newUser));
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id ) {

        if (id==null) {
            throw new RuntimeException("You must define new user");
        } else {
            userService.deleteUser(id);
        }
    }

    @PutMapping()
    public void editUser( @RequestBody User user ){
       userService.editUser(user);
    }

}
