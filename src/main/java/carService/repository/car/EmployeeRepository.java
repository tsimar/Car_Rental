package carService.repository.car;

import carService.entity.Car.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Employee u SET u.name=:name," +
            " u.lastName=:lastName, u.position=:position," +
            " u.userID=:userID, u.carRentalDepartID=:carRentalDepartID WHERE u.id=:id")
    int update(@Param("name") String name, @Param("lastName") String lastName,
               @Param("position") String position,
               @Param("userID") int userID,
               @Param("carRentalDepartID") Long carRentalDepartID,
               @Param("id") Long id);


    @Transactional
    @Query(value = "SELECT e FROM Employee e WHERE e.carRentalDepartID=:carRentalDepartID")
    List<Employee> findAllByIdEmpl(@Param("carRentalDepartID") Long id);



}
