package carService.controller.carHairService;

import carService.entity.CarHairService.CarReturn;
import carService.service.CarHairService.CarReturnService;
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
    public ResponseEntity<List<CarReturn>> getCarReturnByIdCompany(@PathVariable Long companyId, @PathVariable Long userId) {
        return ResponseEntity.ok(carReturnService.getAllByCompanyIdAndUserId(companyId, userId));
    }
}
