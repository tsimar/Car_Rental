package carService.repository.CarHairService;

import carService.entity.CarHairService.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
    @Modifying
    @Query(value = "update reservation set employeeId:employeeId, commentRental=:commentRental where id=:id",nativeQuery = true)
    List<CarRental> update (@Param(value = "employeeId") Long employeeId, @Param(value = "commentRental") String commentRental, @Param(value = "id") Long id);


}
