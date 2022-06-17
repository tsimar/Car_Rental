package carService.controller.carHairService;

import carService.dto.entity.carHairService.carHairService.CarReturnByCompanyDTO;
import carService.entity.CarHairService.CarReturn;
import carService.service.CarHairService.CarReturnService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/return")
@CrossOrigin
public class CarReturnController {
    private final CarReturnService carReturnService;

    public CarReturnController(CarReturnService carReturnService) {
        this.carReturnService = carReturnService;
    }

    @GetMapping("/{companyId}/{userId}")
    public ResponseEntity<List<CarReturnByCompanyDTO>> getCarReturnByIdCompany(@PathVariable Long companyId, @PathVariable Long userId) {
        return ResponseEntity.ok(carReturnService.getAllByCompanyIdAndUserId(companyId, userId));
    }

    @GetMapping
    public ResponseEntity<List<CarReturn>>getAll(){
        return ResponseEntity.ok(carReturnService.getAll());
    }

    @PutMapping("/{id}")
    public void updateReturn (@PathVariable Long id,@RequestBody @Valid CarReturn carReturn){
      carReturnService.updateReturn(carReturn, id);
    }
}
