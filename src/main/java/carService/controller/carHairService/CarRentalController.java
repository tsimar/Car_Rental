package carService.controller.carHairService;


import carService.entity.CarHairService.CarRental;
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

    @GetMapping( "/{companyId}/{userId}")
    public  ResponseEntity<List<CarRental>> getCarRentalByIdCompany(@PathVariable Long companyId,@PathVariable Long userId) {
        return ResponseEntity.ok(carRentalService.getAllByCompIdAndUserId(companyId,userId));
    }

    @GetMapping
    public ResponseEntity<List<CarRental>> getCarRental() {
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
