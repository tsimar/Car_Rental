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
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Employee>> getEmployees(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getAllById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> save (@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }


    @PutMapping()
    public void editEmpl (@RequestBody Employee employee)
    {
        employeeService.editEmpl(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmplById(@PathVariable Long id) {

        employeeService.deleteEmpl(id);
    }
}
