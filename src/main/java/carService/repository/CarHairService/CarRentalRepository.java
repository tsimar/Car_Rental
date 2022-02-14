package carService.repository.CarHairService;

import carService.entity.CarHairService.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
//    @Modifying
//    @Query(value = "update carRental set employeeId:employeeId, commentRental=:commentRental where id=:id",nativeQuery = true)
//    List<CarRental> update (@Param(value = "employeeId") Long employeeId, @Param(value = "commentRental") String commentRental, @Param(value = "id") Long id);


    @Query(value = "SELECT e FROM CarRental e WHERE e.companyId=:companyId AND e.userId=:userId ")
    List<CarRental> findAllByCompanyIdAndUserId(@Param("companyId") Long companyId, @Param("userId") Long userId);

    @Query(value = "SELECT e FROM CarRental e WHERE e.companyId=:companyId ")
    List<CarRental> findAllByCompanyId(@Param("companyId") Long companyId);
}
