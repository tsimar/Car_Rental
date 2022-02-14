package carService.controller.car;

import carService.dto.entity.carHairService.car.CarDepartMainDTO;
import carService.entity.Car.CarRentalDepartment;
import carService.repository.car.CarRentalDepartmentRepository;
import carService.service.car.CarRentalDepartmentService;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import org.slf4j.Logger;

@RestController
@RequestMapping("/branchCompany")
@CrossOrigin
public class CarRentalDepartmentController {


    private final CarRentalDepartmentRepository repository;
    private final CarRentalDepartmentService carRentalDepartmentService;

    private static final Logger logger= LoggerFactory.getLogger(CarRentalDepartmentController.class);

    public CarRentalDepartmentController
            (CarRentalDepartmentService carRentalDepartmentService,final CarRentalDepartmentRepository repository) {
        this.carRentalDepartmentService = carRentalDepartmentService;
        this.repository = repository;
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
