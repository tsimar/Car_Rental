package carService.repository.car;

import carService.entity.Car.DescriptionCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface DescriptionCarRepository extends JpaRepository<DescriptionCar,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE DescriptionCar c SET " +
            "c.carBrand=:carBrand," +
            "c.model=:model," +
            " c.carType=:carType, " +
            "c.productionDate=:productionDate," +
            "c.color=:color," +
            " c.carMileage=:carMileage," +
            " c.statusRental=:statusRental, " +
            "c.carStatus=:carStatus" +
            " WHERE c.id=:id")
    int update(
            @Param("carBrand") String carBrand,
            @Param("model") String model,
            @Param("carType") String carType,
            @Param("productionDate") Date productionDate,
            @Param("color") String color,
            @Param("carMileage") double carMileage,
            @Param("statusRental") String statusRental,
            @Param("carStatus") String carStatus,
            @Param("id") Long id
    );

    @Transactional
    @Query(value = "SELECT d FROM DescriptionCar d WHERE d.carRentalDepartID=:carRentalDepartID")
    List<DescriptionCar> findAllByIdCar(@Param("carRentalDepartID") Long id);
}
