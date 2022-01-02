package carService.controller.car;

import carService.dto.entity.carHairService.car.CarDepartMainDTO;
import carService.entity.Car.CarRentalDepartment;
import carService.service.car.CarRentalDepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branchCompany")
@CrossOrigin
public class CarRentalDepartmentController {
    private final CarRentalDepartmentService carRentalDepartmentService;

    public CarRentalDepartmentController
            (CarRentalDepartmentService carRentalDepartmentService) {
        this.carRentalDepartmentService = carRentalDepartmentService;
    }

    @PostMapping
    public ResponseEntity<CarRentalDepartment> save
            (@RequestBody CarRentalDepartment carRentalDepartment) {
        return ResponseEntity.ok(carRentalDepartmentService.save(carRentalDepartment));
    }


    @GetMapping
    public ResponseEntity<List<CarDepartMainDTO>> getCarRental() {
        return ResponseEntity.ok(carRentalDepartmentService.getAll());
    }

    @PutMapping()
    public void editCarRental
            (@RequestBody CarRentalDepartment carRentalDepartment) {
        carRentalDepartmentService.editCarDepart(carRentalDepartment);
    }

    @DeleteMapping("/{id}")
    public void deleteCarRentalById(@PathVariable Long id) {
        carRentalDepartmentService.deleteCarDepart(id);
    }


}
