package carService.repository.car;

import carService.entity.Car.CarRentalDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface CarRentalDepartmentRepository extends JpaRepository<CarRentalDepartment, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE CarRentalDepartment c SET c.logo=:logo, c.nameRental=:nameRental, c.city=:city, c.address=:address WHERE c.id=:id")
    int update(
            @Param("logo") String logo,
            @Param("nameRental") String nameRental,
            @Param("city") String city,
            @Param("address") String address,
            @Param("id") Long id
    );
}
