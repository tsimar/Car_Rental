package carService.controller.car;


import carService.dto.entity.carHairService.car.DescriptionCarDTO;
import carService.dto.entity.carHairService.car.EmployeeDTO;
import carService.entity.Car.DescriptionCar;
import carService.entity.Car.Employee;
import carService.service.car.DescriptionCarService;
import carService.service.car.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController (EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getCarRental() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @PostMapping
    public ResponseEntity<Employee> save (@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }


    @PutMapping()
    public void editCar (@RequestBody Employee employee)
    {
        employeeService.editCar(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable Long id) {

        employeeService.deleteCar(id);
    }
}
