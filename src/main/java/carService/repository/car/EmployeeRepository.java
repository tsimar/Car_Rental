package carService.repository.car;

import carService.entity.Car.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Employee u SET u.name=:name, u.lastName=:lastName, u.position=:position WHERE u.id=:id")
    int update(@Param("name") String name, @Param("lastName") String lastName,@Param("position") String position, @Param("id") Long id);
}
