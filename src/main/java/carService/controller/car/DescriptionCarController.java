package carService.controller.car;

import carService.dto.entity.carHairService.car.DescriptionCarDTO;
import carService.entity.Car.DescriptionCar;
import carService.service.car.DescriptionCarService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/cars")
@CrossOrigin
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
    public ResponseEntity<DescriptionCar> save (@RequestBody  DescriptionCar descriptionCar){
       DescriptionCar result= descriptionCarService.save(descriptionCar);
    return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
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
