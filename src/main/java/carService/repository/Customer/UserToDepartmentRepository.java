package carService.repository.Customer;

import carService.entity.Customer.UserToDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToDepartmentRepository  extends JpaRepository<UserToDepartment,Long> {

}
