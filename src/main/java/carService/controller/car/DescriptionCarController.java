package carService.controller.car;

import carService.dto.entity.carHairService.car.DescriptionCarDTO;
import carService.entity.Car.DescriptionCar;
import carService.service.car.DescriptionCarService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "http://localhost:8080")
public class DescriptionCarController {
private final DescriptionCarService descriptionCarService;
public DescriptionCarController (DescriptionCarService descriptionCarService)
{
    this.descriptionCarService=descriptionCarService;
}
    @GetMapping("/{id}")
    public ResponseEntity<List<DescriptionCarDTO>> getCarRental(@PathVariable Long id) {
        return ResponseEntity.ok(descriptionCarService.getAllById(id));
    }
    @GetMapping
    public ResponseEntity<List<DescriptionCarDTO>> getCarRental() {
        return ResponseEntity.ok(descriptionCarService.getAll());
    }
    @PostMapping
    public ResponseEntity<DescriptionCar> save (@RequestBody DescriptionCar descriptionCar){
    return ResponseEntity.ok(descriptionCarService.save(descriptionCar));
    }


    @PutMapping()
    public void editCar (@RequestBody DescriptionCar descriptionCar)
    {
      descriptionCarService.editCar(descriptionCar);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable Long id) {

       descriptionCarService.deleteCar(id);
    }

}
