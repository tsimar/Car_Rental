package carService.controller.carHairService;


import carService.dto.entity.carHairService.CarRentalDTO;
import carService.entity.CarHairService.CarRental;
import carService.entity.Customer.User;
import carService.service.CarHairService.CarRentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
@CrossOrigin
public class CarRentalController {
    private final CarRentalService carRentalService;

    public CarRentalController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    @PostMapping()
    public ResponseEntity<CarRental> addCarRental(@RequestBody CarRental carRental) {
        return ResponseEntity.ok(carRentalService.save(carRental));
    }

    @GetMapping
    public ResponseEntity<List<CarRentalDTO>> getCarRental() {
        return ResponseEntity.ok(carRentalService.getAll());
    }

//    @DeleteMapping("/{id}")
//    public void deleteDepart(@PathVariable Long id ) {
//
//        if (id==null) {
//            throw new RuntimeException("You must define new user");
//        } else {
//
//           carRentalService.deleteDepart(id);
//        }
//    }
//
//    @PutMapping()
//    public void editDepart( @RequestBody User user ){
//        carRentalService.editDepart(user);
//    }

}
