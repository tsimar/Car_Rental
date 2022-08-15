package carService.repository.Customer;

import carService.entity.CarHairService.CarReturn;
import carService.entity.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerInfoRepository extends JpaRepository <Customer,Long> {

    @Query (value = "SELECT c FROM Customer c WHERE c.id=:id")
    List<Customer> findAllByUserId(@Param("id") Long userId);



}
