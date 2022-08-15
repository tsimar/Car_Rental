package carService.controller.customer;

import carService.entity.Customer.Customer;
import carService.service.customer.CustomerInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    private final CustomerInfoService customerInfoService;


    public CustomerController(CustomerInfoService customerInfoService) {
        this.customerInfoService = customerInfoService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Customer>> findAllByUserId(@PathVariable Long userId) {
        List<Customer> my1 = customerInfoService.getAllByUserId(userId);
        List<Customer> myP = new ArrayList<>();
        for (Customer item : my1) {
            Customer newCustomer = new Customer();
            newCustomer.setId(item.getId());
            newCustomer.setNameCustomer(item.getNameCustomer());
            newCustomer.setLastNameCustomer(item.getLastNameCustomer());
            newCustomer.setAddress(item.getAddress());
            newCustomer.setEmail(item.getEmail());
//            newCustomer.setUser(item.getUser().getId());
//            System.out.println(item.getUser().getId());
            myP.add(newCustomer);
        }
        return ResponseEntity.ok(myP);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerInfoService.getAll());
    }
}
