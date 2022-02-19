package carService.repository.CarHairService;

import carService.entity.CarHairService.CarReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarReturnRepository extends JpaRepository<CarReturn, Long> {

@Query(value = "SELECT e FROM CarReturn e WHERE e.companyId=:companyId AND e.userId=:userId ")
    List<CarReturn> findAllByCompanyIdAndUserId(@Param("companyId") Long companyId, @Param("userId") Long userId);

@Query(value = "SELECT e FROM CarReturn e WHERE e.companyId=:companyId ")
    List<CarReturn> findAllByCompanyId(@Param("companyId") Long companyId);
}
