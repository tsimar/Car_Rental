package carService.repository.CarHairService;

import carService.entity.CarHairService.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Modifying
    @Query(value = "update reservation set car_rental_id=35 where id=32",nativeQuery = true)
    int update();//(@Param(value = "rentalId") Long id, @Param(value = "reserId") Long resId);



}
